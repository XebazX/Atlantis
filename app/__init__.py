from flask import Flask
from flask_sqlalchemy import SQLAlchemy
from flask_login import LoginManager
import os
from app.extesiones import db
login_manager = LoginManager()
 


def create_app():
    app = Flask(__name__)
    app.secret_key = os.urandom(24)
    app.config.from_object('config.Config')
    
    db.init_app(app)

    login_manager.init_app(app)
    login_manager.login_view = 'Administrador.login'
    
    @login_manager.user_loader
    def load_user(idUser): # Flask-Login intentará cargar al usuario actual basándose en su identificador.
        from .models.Administrador import Administrador
        from .models.Cliente import Cliente
        from .routes.Administrador_routes import tipo
        
        if tipo == 0 : 
             return Cliente.query.get(int(idUser))
        elif tipo == 1 : 
             return Administrador.query.get(int(idUser))
        
        # since the user_id is just the primary key of our user table, use it in the query for the user
       
    

    from app.routes import Administrador_routes, Categoria_routes, Cliente_routes, Detalle_routes, Factura_routes, Productos_routes, Carrito
    app.register_blueprint(Administrador_routes.bp)
    app.register_blueprint(Categoria_routes.bp)
    app.register_blueprint(Cliente_routes.bp)
    app.register_blueprint(Detalle_routes.bp)
    app.register_blueprint(Factura_routes.bp)
    app.register_blueprint(Productos_routes.bp)
    app.register_blueprint(Carrito.bp)
    
    

    return app