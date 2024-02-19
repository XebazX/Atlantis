from flask import Blueprint, render_template, request, redirect, url_for
from app.extesiones import db
from app.models.Detalle import Detalle

bp = Blueprint("Detalle", __name__)


@bp.route("/Detalle")
def index():
    data = Detalle.query.all()
    return render_template("Detalle/index.html", data=data)


@bp.route("/Detalle/add", methods=["GET", "POST"])
def add():
    if request.method == "POST":
        cantidad = request.form["cantidad"]
        subtotal = request.form["subtotal"]
        factura = request.form["factura"]
        producto = request.form["producto"]

        NDetalle = Detalle(
            cantidadDetalle=cantidad,
            subTotalDetalle=subtotal,
            Factura_idFactura=factura,
            Producto_idProducto=producto,
        )
        db.session.add(NDetalle)
        db.session.commit()

        return redirect(url_for("Detalle.index"))

    return render_template("Detalle/add.html")


@bp.route("/Detalle/edit/<int:id>", methods=["GET", "POST"])
def edit(id):
    detalle = Detalle.query.get_or_404(id)

    if request.method == "POST":
        detalle.cantidad = request.form["cantidad"]
        detalle.subtotal = request.form["subtotal"]
        detalle.factura = request.form["factura"]
        detalle.producto = request.form["producto"]
        db.session.commit()
        return redirect(url_for("Detalle.index"))

    return render_template("Detalle/edit.html", detalle=detalle)


@bp.route("/Detalle/delete/<int:id>")
def delete(id):
    detal = Detalle.query.get_or_404(id)

    db.session.delete(detal)
    db.session.commit()

    return redirect(url_for("Detalle.index"))
