package br.com.douglasfood.pagamentos.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.douglasfood.pagamentos.dto.PagamentoDTO;
import br.com.douglasfood.pagamentos.service.PagamentoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/pagamentos")
@RequiredArgsConstructor
public class PagamentoController {

  private final PagamentoService pagamentoService;

  @GetMapping
  public List<PagamentoDTO> listar() {
    return pagamentoService.getAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<PagamentoDTO> getById(@PathVariable @NotNull Long id) {
    PagamentoDTO dto = pagamentoService.getById(id);

    return ResponseEntity.ok(dto);
  }

  @PostMapping
  public ResponseEntity<PagamentoDTO> cadastar(@RequestBody @Valid PagamentoDTO dto, UriComponentsBuilder uriBuilder) {
    PagamentoDTO pagamento = pagamentoService.createPayment(dto);
    var uri = uriBuilder.path("/pagamentos/{id}").buildAndExpand(pagamento.getId()).toUri();

    return ResponseEntity.created(uri).body(pagamento);
  }

  @PutMapping("/{id}")
  public ResponseEntity<PagamentoDTO> atualizar(@PathVariable @NotNull Long id, @RequestBody @Valid PagamentoDTO dto ){
    PagamentoDTO pagamentoAtualizado = pagamentoService.updatePayment(id, dto);

    return ResponseEntity.ok(pagamentoAtualizado);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deletar(@PathVariable @NotNull Long id){
    pagamentoService.deletePayment(id);

    return ResponseEntity.noContent().build();
  }

}
