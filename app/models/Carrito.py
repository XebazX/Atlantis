from app.models.Productos import Producto


class Carrito:
    def __init__(self):
        self.carrito = []

    def agregar_producto(self, idProducto, cantidad):
        producto = Producto.query.get(idProducto)
        if producto:
            item = {'producto': producto, 'cantidad': cantidad}
            self.carrito.append(item)
            
            
    def eliminar_producto(self, idProducto, cantidad):
        for item in self.carrito:
            if item['producto'].idProducto == idProducto:
                if cantidad >= item['cantidad']:
                    self.carrito.remove(item)
                else:
                    item['cantidad'] -= cantidad
                break   
        
        
    def calcular_total(self):
        return sum(item['producto'].precioproducto * item['cantidad'] for item in self.carrito)
    
    def tamañoD(self):   
        return len(self.carrito)

    def getItems(self):
        return self.carrito
    
    def vaciarcarrito(self):
        self.carrito = []
    