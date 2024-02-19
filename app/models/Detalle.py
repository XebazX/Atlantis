from app.extesiones import db
from sqlalchemy.orm import relationship

class Detalle(db.Model):
    idDetalle = db.Column(db.Integer, primary_key=True)
    cantidadDetalle = db.Column(db.Integer, nullable=True)
    Factura_idFactura = db.Column(db.Integer, db.ForeignKey('factura.idFactura'), nullable=False)
    subTotalDetalle = db.Column(db.String(45), nullable=True)
    Producto_idProducto = db.Column(db.Integer, db.ForeignKey('producto.idProducto'), nullable=False)
    allp = db.relationship("Producto")