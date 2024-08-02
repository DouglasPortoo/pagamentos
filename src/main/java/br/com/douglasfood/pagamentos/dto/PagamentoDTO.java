package br.com.douglasfood.pagamentos.dto;

import java.math.BigDecimal;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import br.com.douglasfood.pagamentos.enums.Status;
import lombok.Data;

@Data
public class PagamentoDTO {
  private Long id;
  private BigDecimal valor;
  private String nome;
  private String numero;
  private String expiracao;
  private String codigo;
  private Status status;
  private Long pedidoId;
  private Long formaDePagamentoId;
}
