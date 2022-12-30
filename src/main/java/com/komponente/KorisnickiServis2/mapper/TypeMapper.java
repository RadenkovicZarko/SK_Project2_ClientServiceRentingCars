package com.komponente.KorisnickiServis2.mapper;

import com.komponente.KorisnickiServis2.domain.Type;
import com.komponente.KorisnickiServis2.dto.TypeDto;
import org.springframework.stereotype.Component;

@Component
public class TypeMapper {

    public TypeDto typeToTypeDto(Type type)
    {
        TypeDto typeDto=new TypeDto();
        typeDto.setId(type.getId());
        typeDto.setName(type.getName());
        return typeDto;
    }
}
