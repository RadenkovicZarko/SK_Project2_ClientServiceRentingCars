package com.komponente.KorisnickiServis2.mapper;

import com.komponente.KorisnickiServis2.domain.Model;
import com.komponente.KorisnickiServis2.domain.Type;
import com.komponente.KorisnickiServis2.dto.ModelDto;
import com.komponente.KorisnickiServis2.dto.TypeDto;
import org.springframework.stereotype.Component;

@Component
public class ModelMapper {
    public ModelDto modelToModelDto(Model model)
    {
        ModelDto modelDto=new ModelDto();
        modelDto.setId(model.getId());
        modelDto.setName(model.getName());
        return modelDto;
    }
}
