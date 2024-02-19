from flask import Blueprint, render_template, request, redirect, url_for
from app.extesiones import db
from app.models.Cliente import Cliente
from flask_login import login_user, current_user, logout_user, login_required
from flask_bcrypt import Bcrypt

bp = Blueprint('Cliente', __name__)


@bp.route('/Cliente')
def index():
    data = Cliente.query.all()
    return render_template('Cliente/index.html', data=data)


@bp.route('/Cliente/add', methods=['GET', 'POST'])
def add():
    if request.method == 'POST':
        nombre = request.form['nombre']
        documento = request.form['documento']
        correo = request.form['correo']
        celular = request.form['celular']
        contrasena = request.form['contrasena']
        
        NCliente = Cliente(nombreCliente=nombre, documentoCliente=documento, direccionCliente=correo, celularCliente=celular, contrasenaCliente=contrasena)
        db.session.add(NCliente)
        db.session.commit()
        
        return redirect(url_for('Cliente.index'))

    return render_template('Cliente/add.html')

@bp.route('/Cliente/registro', methods=['GET', 'POST'])
def registro():
    if request.method == 'POST':
        nombre = request.form['nombre']
        documento = request.form['documento']
        correo = request.form['correo']
        celular = request.form['celular']
        contrasena = request.form['contrasena']
        
        NCliente = Cliente(nombreCliente=nombre, documentoCliente=documento, direccionCliente=correo, celularCliente=celular, contrasenaCliente=contrasena)
        db.session.add(NCliente)
        db.session.commit()
        
        return redirect(url_for('login.index'))

    return render_template('Cliente/registro.html')

@bp.route('/Cliente/edit/<int:id>', methods=['GET', 'POST'])
def edit(id):
    cliente = Cliente.query.get_or_404(id)

    if request.method == 'POST':
        cliente.nombre = request.form['nombre']
        cliente.documento = request.form['documento']
        cliente.correo = request.form['correo']
        cliente.celular = request.form['celular']
        db.session.commit()
        return redirect(url_for('Cliente.index'))

    return render_template('Cliente/edit.html', cliente=cliente)
    

@bp.route('/Cliente/delete/<int:id>')
def delete(id):
    client = Cliente.query.get_or_404(id)
    
    db.session.delete(client)
    db.session.commit()

    return redirect(url_for('Cliente.index'))


