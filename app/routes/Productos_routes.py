from flask import Blueprint, render_template, request, redirect, url_for
from app.extesiones import db
from app.models.Categoria import Categoria
from app.models.Productos import Producto
from flask_login import login_user, current_user, logout_user, login_required
import os

bp = Blueprint('Productos', __name__)


@bp.route("/Producto")
@login_required
def index():
    
    data = Producto.query.all()
    return render_template("Productos/index.html",  data=data)

@bp.route("/ProductoAdm")
@login_required
def indexAdm():
    
    data = Producto.query.all()
    return render_template("Productos/indexAdm.html",  data=data)

    


@bp.route("/Productos/add", methods=["GET", "POST"])
@login_required
def add():

    categoria = Categoria.query.all()
    if request.method == "POST":
        nombre = request.form["nombre"]
        detalle = request.form["detalle"]
        precio = request.form["precio"]
        stock = request.form["stock"]
        imagen = request.files["imag"]
        categoria = request.form["categoria"]
        

        NProducto = Producto(
            nombreProducto=nombre,
            detalleProducto=detalle,
            precioProducto=precio,
            stockProducto=stock,
            Categoria_idCategoria=categoria,
            imgp=imagen.filename,
        )
        db.session.add(NProducto)
        db.session.commit()
        
        if "imag" in request.files:
            foto = request.files["imag"]
            if foto.filename != "":
                saveimg(foto)
                
        return redirect(url_for("Productos.index", Categorias=categoria))
    
    
    return render_template("Productos/add.html", Categorias=categoria )


@bp.route("/Productos/edit/<int:id>", methods=["GET", "POST"])
@login_required

def edit(id):
    producto = Producto.query.get_or_404(id)
    categoriia = Categoria.query.all()

    if request.method == "POST":
        producto.nombreProducto = request.form["nombre"]
        producto.detalleProducto = request.form["detalle"]
        producto.precioProducto = request.form["precio"]
        producto.stockProducto = request.form["stock"]
        producto.Categoria_idCategoria = request.form["categoria"]
        
        
        if "imag" in request.files:
            foto = request.files["imag"]
            
            if foto.filename != "":
                deleteimg(producto.idProducto)
                print(producto.imgp)
                producto.imgp = foto.filename
                print(foto.filename)
                print(producto.imgp)
                saveimg(foto)

              
        print(producto.imgp)
        db.session.commit()
        print(producto.imgp)

        return redirect(url_for("Productos.index"))

    return render_template("Productos/edit.html", producto=producto, categoriia=categoriia)


@bp.route("/Productos/delete/<int:id>")
@login_required

def delete(id):
    detal = Producto.query.get_or_404(id)
    deleteimg(id)

    db.session.delete(detal)
    db.session.commit()

    return redirect(url_for("Productos.index"))



def saveimg(file):
    from run import app
    
    filename = file.filename 
    destination = os.path.join(app.root_path,"static","imagenes")
    file.save(
        os.path.join(destination,filename)
    )
    
    
    
def deleteimg(idProducto):
    from run import app
    
    imgpr = Producto.query.get_or_404(idProducto).imgp
    rutaimg = os.path.join(app.root_path,"static","imagenes", imgpr)
    if os.path.exists(rutaimg):
        os.remove(rutaimg)
    
    
