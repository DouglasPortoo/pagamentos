import org.springframework.data.jpa.repository.JpaRepository;

import br.com.douglasfood.pagamentos.model.Pagamento;

public interface PagamentosRepository extends JpaRepository<Pagamento, Long> {
  
}
