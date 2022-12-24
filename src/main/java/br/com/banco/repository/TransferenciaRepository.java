package br.com.banco.repository;

import br.com.banco.entity.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

    @Query("SELECT t FROM Transferencia t WHERE t.conta.id =?1")
        public List<Transferencia> findAllByAccount(Long idConta);

    @Query("SELECT t FROM Transferencia t WHERE t.conta.id =?1 AND t.dataTransferencia BETWEEN ?2 AND ?3")
    public List<Transferencia> findAllByAccountAndDate(Long idConta, LocalDateTime dataInicio, LocalDateTime dataFim);

    @Query("SELECT t FROM Transferencia t WHERE t.conta.id =?1 AND t.dataTransferencia BETWEEN ?2 AND ?3 AND t.nomeOperadorTransacao =?4")
    public List<Transferencia> findAllByAccountAndDateAndOperator(Long idConta, LocalDateTime dataInicio, LocalDateTime dataFim, String nomeOperadorTransacao);
}
