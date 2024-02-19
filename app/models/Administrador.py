from flask_login import UserMixin
from app.extesiones import db

class Administrador(db.Model, UserMixin):
    idAdministrador = db.Column(db.Integer, primary_key=True)
    correoAdm = db.Column(db.String(45), nullable=True)
    contrasenaAdm = db.Column(db.String(255), nullable=True)
    
    def get_id(self):
        return str(self.idAdministrador)