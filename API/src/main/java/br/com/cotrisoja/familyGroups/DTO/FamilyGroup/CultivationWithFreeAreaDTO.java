package br.com.cotrisoja.familyGroups.DTO.FamilyGroup;

import java.util.List;

public record CultivationWithFreeAreaDTO (
        Long familyGroupId,
        Double freeArea,
        Double totalArea,
        CultivationResponseDTO cultivations
){
}
