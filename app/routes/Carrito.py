from app.extesiones import db
from flask import Blueprint, render_template, request, redirect, url_for, render_template, redirect, url_for, request, flash
from app.models.Carrito import Carrito
from app.models.Productos import Producto
from app.models.Factura import Factura
from app.models.Administrador import Administrador
from flask_login import current_user
from datetime import datetime
from app.models.Detalle import Detalle
from flask_login import login_user, current_user, logout_user, login_required




bp = Blueprint('carritos', __name__)
carrito_compras = Carrito()

@bp.route('/ListarCarrito')
def listar():
    items = carrito_compras.getItems()
    
    
    
    
        
        
    return render_template('productos/List.html', items=items)

@bp.route('/ListarProductos')
def index():
    productos = carrito_compras.getItems()
    return render_template('Carrito/index.html', productos=productos)

@bp.route('/agregar/<int:id>', methods=['POST'])
def agregar_al_carrito(id):
    producto = Producto.query.get(id)

    cantidad = int(request.form.get('cantidad', 1))
    if producto.stockProducto < cantidad:
        return redirect(url_for('Productos.index'))

    carrito_compras.agregar_producto(id, cantidad)
    

    return redirect(url_for('Productos.index'))
    #return "Entra a agregar corrito"
    
    
@bp.route('/eliminar/<int:id>', methods=['POST'])
def eliminar_del_carrito(id):
    cantidad = int(request.form.get('cantidad', 1))
    carrito_compras.eliminar_producto(id, cantidad)
    return redirect(url_for('carritos.index')) if carrito_compras.tamañoD() > 0 else redirect(url_for('Productos.index'))
    #return "Entra a agregar corrito"

@bp.route('/realizar_compra')
def realizar_compra():
    total = carrito_compras.calcular_total()
    return render_template('realizar_compra.html', total=total)

# @bp.route('/generar_factura', methods=['POST'])
# def generar_factura():
#     total = carrito_compras.calcular_total()
#     # Aquí puedes almacenar la información en la base de datos (crear registros en Carrito y Factura)
#     # y luego limpiar el carrito de compras
#     carrito_compras.carrito = []
#     return render_template('factura.html', total=total)

@bp.route('/itemscarrito', methods=['GET', 'POST'])
def tCarrito():
    a = carrito_compras.tamañoD()
    print("Entra a carrito rutas", a)
    return f"Entra a carrito {carrito_compras.tamañoD()}"

@bp.route("/Carrito/factura", methods=["GET", "POST"])
@login_required
def generar_factura():
    
    carrito = carrito_compras.getItems()
    
    if carrito:  # Verifica si el carrito no está vacío
        fecha = datetime.now()
        total = 0
        productos_factura = []

        # Calcular el total y recopilar los detalles de los productos
        for item in carrito:
            producto = item["producto"]
            cantidad = item["cantidad"]
            subtotal = producto.precioProducto * cantidad
            total += subtotal
            productos_factura.append({
                "id": producto.idProducto,
                "nombre": producto.nombreProducto,
                "precio": producto.precioProducto,
                "cantidad": cantidad,
                "subtotal": subtotal
            })

        
        # Crear la factura en la base de datos
        nueva_factura = Factura(
            fechaFactura=fecha,
            subTotalFactura=total,
            cliente_idcliente=current_user.idCliente  # Aquí debes especificar el ID del cliente actual
        )
        db.session.add(nueva_factura)
        db.session.commit()
        print(len(productos_factura))

        # Agregar los detalles de los productos a la factura
        for item in carrito:
            producto = item["producto"]
            cantidad = item["cantidad"]
            subtotal = producto.precioProducto * cantidad
            detalle_factura = Detalle(
                cantidadDetalle=cantidad,
                Factura_idFactura=nueva_factura.idFactura,
                Producto_idProducto=producto.idProducto,
                subTotalDetalle=subtotal
            )
            db.session.add(detalle_factura)
            db.session.commit()
    
        # Vaciar el carrito después de completar la compra
        carrito_compras.vaciarcarrito()

        # Renderizar la plantilla de la factura con los datos necesarios
        return render_template('Carrito/factura.html', fecha=fecha, total=total, productos_factura=productos_factura)

    else:
        # Si el carrito está vacío, redirecciona al usuario a algún lugar apropiado
        return redirect(url_for('Productos.index'))