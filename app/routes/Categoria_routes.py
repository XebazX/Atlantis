from flask import Blueprint, render_template, request, redirect, url_for
from app.extesiones import db
from app.models.Categoria import Categoria

bp = Blueprint('Categoria', __name__)


@bp.route('/Categoria')
def index():
    data = Categoria.query.all()
    return render_template('Categoria/index.html', data=data)


@bp.route('/Categoria/add', methods=['GET', 'POST'])
def add():
    if request.method == 'POST':
        nombre = request.form['nombre']
        
        NCategoria = Categoria(nombreCategoria=nombre)
        db.session.add(NCategoria)
        db.session.commit()
        
        return redirect(url_for('Categoria.index'))

    return render_template('Categoria/add.html')

@bp.route('/Categoria/edit/<int:id>', methods=['GET', 'POST'])
def edit(id):
    categoria = Categoria.query.get_or_404(id)

    if request.method == 'POST':
        categoria.nombreCategoria = request.form['nombre']
        db.session.commit()
        return redirect(url_for('Categoria.index'))

    return render_template('Categoria/edit.html', categoria=categoria)
    

@bp.route('/Categoria/delete/<int:id>')
def delete(id):
    categor = Categoria.query.get_or_404(id)
    
    db.session.delete(categor)
    db.session.commit()

    return redirect(url_for('Categoria.index'))
