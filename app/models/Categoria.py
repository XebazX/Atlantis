from app.extesiones import db
from sqlalchemy.orm import relationship

class Categoria(db.Model):
    idCategoria = db.Column(db.Integer, primary_key=True)
    nombreCategoria = db.Column(db.String(45), nullable=True)