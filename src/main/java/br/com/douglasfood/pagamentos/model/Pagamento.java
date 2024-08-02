package br.com.douglasfood.pagamentos.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import br.com.douglasfood.pagamentos.enums.Status;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "pagamentos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pagamento{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Positive
  private BigDecimal valor;

  @NotBlank
  @Size(max = 100)
  private String nome;

  @NotBlank
  @Size(max = 19)
  private String numero;

  @NotBlank
  @Size(max = 7)
  private String expiracao;

  @NotBlank
  @Size(max = 3)
  private String codigo;

  @Enumerated(EnumType.STRING)
  private Status status;

  @NotNull
  private Long pedidoId;

  @NotNull
  private Long formaDePagamentoId;

}