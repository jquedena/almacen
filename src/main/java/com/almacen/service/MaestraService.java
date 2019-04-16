package com.almacen.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.almacen.dto.DataTableDTO;
import com.almacen.dto.in.MaestraInDTO;
import com.almacen.dto.out.MaestraOutDTO;
import com.almacen.model.Maestra;
import com.almacen.repository.MaestraRepository;

@Service
public class MaestraService {

    @Autowired
    private MaestraRepository maestraRepository;

    @Transactional(readOnly = true)
    public DataTableDTO<MaestraOutDTO> buscar(MaestraInDTO maestra, int page) {
        Long maeCodigo = maestra.getMaestra().getMaeCodigo();
        String maeDeslar = "%" + maestra.getMaestra().getMaeDeslar() + "%";
        Long almMarca = maestra.getMaestra().getAlmMarca().getMarMarca();
        Page<Maestra> pageOut = maestraRepository.findByPageable(maeCodigo, maeDeslar, almMarca, PageRequest.of(page, 10));
        List<MaestraOutDTO> out = pageOut.getContent()
                .stream()
                .map(MaestraOutDTO::new)
                .collect(Collectors.toList());
        DataTableDTO<MaestraOutDTO> pageOutDTO = new DataTableDTO<>();
        pageOutDTO.setData(out);
        pageOutDTO.setRecordsFiltered(pageOut.getTotalElements());
        pageOutDTO.setRecordsTotal(pageOut.getTotalElements());
        return pageOutDTO;
    }

    @Transactional
    public MaestraOutDTO insertar(MaestraInDTO maestra) {
        return new MaestraOutDTO(maestraRepository.saveAndFlush(maestra.getMaestra()));
    }
}
