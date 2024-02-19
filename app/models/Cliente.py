from app.extesiones import db
from sqlalchemy.orm import relationship
from flask_login import UserMixin

class Cliente(db.Model, UserMixin):
    idcliente = db.Column(db.SmallInteger, primary_key=True)
    nombreCliente = db.Column(db.String(45), nullable=True)
    documentoCliente = db.Column(db.String(45), nullable=True)
    direccionCliente = db.Column(db.String(45), nullable=True)
    celularCliente = db.Column(db.String(45), nullable=True)
    contrasenaCliente = db.Column(db.String(256), nullable=True)
    
    def get_id(self):
        return str(self.idcliente)