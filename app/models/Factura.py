from app.extesiones import db
from sqlalchemy.orm import relationship

class Factura(db.Model):
    idFactura = db.Column(db.Integer, primary_key=True)
    fechaFactura = db.Column(db.TIMESTAMP, nullable=True)
    subTotalFactura = db.Column(db.String(45), nullable=True)
    cliente_idcliente = db.Column(db.SmallInteger, db.ForeignKey('cliente.idcliente'), nullable=False)