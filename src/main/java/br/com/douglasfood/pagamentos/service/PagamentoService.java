package br.com.douglasfood.pagamentos.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.douglasfood.pagamentos.dto.PagamentoDTO;
import br.com.douglasfood.pagamentos.enums.Status;
import br.com.douglasfood.pagamentos.model.Pagamento;
import br.com.douglasfood.pagamentos.repository.PagamentosRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PagamentoService {
  
  private final PagamentosRepository pagamentoRepository;

  private final ModelMapper modelMapper;

  public List<PagamentoDTO> getAll(){
    return pagamentoRepository.findAll().stream()
      .map(pagamento -> modelMapper.map(pagamento, PagamentoDTO.class))
      .collect(Collectors.toList());
  }

  public PagamentoDTO getById(Long id){
    Optional<Pagamento> optionalPagamento = pagamentoRepository.findById(id);

    Pagamento pagamento = optionalPagamento.orElseThrow(EntityNotFoundException::new);

    return modelMapper.map(pagamento, PagamentoDTO.class);
  }

  public PagamentoDTO createPayment(PagamentoDTO pagamentoDTO){
    Pagamento pagamento = modelMapper.map(pagamentoDTO, Pagamento.class);
    pagamento.setStatus(Status.CRIADO);
    pagamentoRepository.save(pagamento);

    return modelMapper.map(pagamento, PagamentoDTO.class);
  }

  public PagamentoDTO updatePayment(Long id, PagamentoDTO pagamentoDTO){
    Pagamento pagamento = modelMapper.map(pagamentoDTO, Pagamento.class);
    pagamento.setId(id);
    pagamento = pagamentoRepository.save(pagamento);

    return modelMapper.map(pagamento, PagamentoDTO.class);
  }

  public void deletePayment(Long id){
    pagamentoRepository.deleteById(id);
  }


}
