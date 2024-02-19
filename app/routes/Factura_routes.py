from flask import Blueprint, render_template, request, redirect, url_for
from app.extesiones import db
from app.models.Factura import Factura
from app.models.Productos import Producto
from app.models.Detalle import Detalle
from app.routes.Carrito import carrito_compras
from datetime import datetime
from flask_login import current_user
from flask_login import login_user, current_user, logout_user, login_required
from sqlalchemy import func


bp = Blueprint("Factura", __name__)


@bp.route("/Factura")
def index():
    data = Factura.query.all()
    return render_template("Factura/index.html", data=data)


@bp.route("/Factura/add", methods=["GET", "POST"])
def add():
    if request.method == "POST":
        fecha = request.form["fecha"]
        subtotalfactura = request.form["subtotalfactura"]
        cliente = request.form["cliente"]

        NFactura = Factura(
            fechaFactura=fecha,
            subTotalfactura=subtotalfactura,
            cliente_idcliente=cliente,
        )
        db.session.add(NFactura)
        db.session.commit()

        return redirect(url_for("Factura.index"))

    return render_template("Factura/add.html")


@bp.route("/Factura/edit/<int:id>", methods=["GET", "POST"])
def edit(id):
    factura = Factura.query.get_or_404(id)

    if request.method == "POST":
        factura.fecha = request.form["fecha"]
        factura.subtotalfactura = request.form["subtotalfactura"]
        factura.cliente = request.form["cliente"]
        db.session.commit()
        return redirect(url_for("Factura.index"))

    return render_template("Factura/edit.html", factura=factura)


@bp.route("/Factura/delete/<int:id>")
def delete(id):
    detal = Factura.query.get_or_404(id)

    db.session.delete(detal)
    db.session.commit()

    return redirect(url_for("Factura.index"))


@bp.route("/FacturaG",methods=["GET", "POST"])
@login_required
def buy():
    
    



        car = carrito_compras.getItems()

        total = 0

        subp = {  }

        for item in car:
            precioproducto = int( item["producto"].precioProducto)
            cantidad =int( item["cantidad"])


            total+=precioproducto * cantidad
            subp[f'{item["producto"].nombreProducto}'] = precioproducto * cantidad


        Nfactura = Factura(
            idFactura=None,
            fechaFactura=func.now(),
            subTotalFactura=total,
            cliente_idcliente=current_user.idcliente
        )
        db.session.add(Nfactura)
        db.session.commit()
        id_factura_generada = Nfactura.idFactura



        for carrito in car:
            precioproducto = carrito["producto"].precioProducto
            cantidad = carrito["cantidad"]
            subtotal= int(precioproducto) * int(cantidad)
            detallefactura = Detalle(idDetalle=None,cantidadDetalle=cantidad ,Factura_idFactura=id_factura_generada,Producto_idProducto=carrito["producto"].idProducto, subTotalDetalle=subtotal )
            db.session.add(detallefactura)
            producto = Producto.query.get(carrito["producto"].idProducto)
            producto.stockProducto -= cantidad
            # carrito["producto"].stockProducto -= cantidad
            db.session.commit()

        productos_factura = Detalle.query.filter_by(Factura_idFactura=id_factura_generada).all()

        carrito_compras.vaciarcarrito()
        return render_template('Carrito/factura.html', fecha=Nfactura.fechaFactura, total=total, productos_factura=productos_factura)

        # return render_template("Factura/index.html", data=data)
