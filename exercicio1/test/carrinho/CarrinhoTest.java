package carrinho;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;




@DisplayName("Classe de teste para o carrinho")
public class CarrinhoTest {
	private Carrinho car;
	
	@BeforeEach()
    public void inicializa() {
      car = new Carrinho();
    }
  
  @DisplayName("Testa se o método pega corretamente a quantidade de itens no carrinho")
  @Test
  public void testGetQtdItems() {
    Assertions.assertEquals(car.getQtdeItems(), 0);
  }

  @DisplayName("Testa se um produto foi corretamente adicionado ao carrinho")
  @Test
  public void testAddItem() {
    Produto prod = new Produto("Maçã", 4.25);
    car.addItem(prod);
    Assertions.assertEquals(car.getQtdeItems(), 1);
  }

  @DisplayName("Testa se um produto consegue ser removido do carrinho")
  @Test
  public void testRemoveItem() {
    Produto prod = new Produto("Maizena", 3.75);
    car.addItem(prod);
    Assertions.assertDoesNotThrow(() -> car.removeItem(prod)); 
    Assertions.assertEquals(car.getQtdeItems(), 0);
  }
  
  @DisplayName("Testa se a função lança a exceção ao tentar remover um produto que não está no carrinho")
  @Test
  public void testRemoveItemProductNotFoundException() {
    Produto prod = new Produto("Maizena", 3.75);
    assertThrows(ProdutoNaoEncontradoException.class, () -> car.removeItem(prod));

  }
  @DisplayName("Testa se após adicionar itens ao carrinho e esvaziá-lo, ele permanece vazio")  
  @Test
  public void testEsvazia() {
    Produto prod = new Produto("Maçã", 4.25);
    Produto prod2 = new Produto("Maizena", 3.75);
    car.addItem(prod);
    car.addItem(prod2);
    car.esvazia();
    Assertions.assertEquals(car.getQtdeItems(), 0);
  }
  
  @DisplayName("Testa se o valor total calculado corresponde ao valor total do carrinho")  
  @Test
  public void testValorTotal() {
    Produto prod = new Produto("Maçã", 4.25);
    Produto prod2 = new Produto("Maizena", 3.75);
    car.addItem(prod);
    car.addItem(prod2);    
    Assertions.assertEquals(car.getValorTotal(), 8.0);
  }
}