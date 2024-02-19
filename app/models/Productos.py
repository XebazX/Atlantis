from app.extesiones import db
from sqlalchemy.orm import relationship

class Producto(db.Model):
    idProducto = db.Column(db.Integer, primary_key=True)
    nombreProducto = db.Column(db.String(45), nullable=True)
    detalleProducto = db.Column(db.String(45), nullable=True)
    precioProducto = db.Column(db.Integer, nullable=True)
    stockProducto = db.Column(db.Integer, nullable=True)
    Categoria_idCategoria = db.Column(db.Integer, db.ForeignKey('categoria.idCategoria'), nullable=False)
    imgp = db.Column(db.String(150), nullable=True)
    categor = db.relationship("Categoria")