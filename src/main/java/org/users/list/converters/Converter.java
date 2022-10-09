package org.users.list.converters;

public interface Converter<DTO, View> {

    View fromDTOtoView(DTO dto);

    DTO fromViewToDTO(View view);
}
