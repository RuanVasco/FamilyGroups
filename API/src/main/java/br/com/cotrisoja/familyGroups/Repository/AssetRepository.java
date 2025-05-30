package br.com.cotrisoja.familyGroups.Repository;

import br.com.cotrisoja.familyGroups.Entity.Asset;
import br.com.cotrisoja.familyGroups.Entity.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AssetRepository extends JpaRepository<Asset, Long> {
    Optional<Asset> findByOwner_RegistrationNumberAndIdSap(String registrationNumber, Long idSap);

    @Query("""
        SELECT MAX(a.idSap) FROM Asset a
        WHERE a.owner.registrationNumber = :registrationNumber
    """)
    Optional<Long> findMaxIdSapByOwner(@Param("registrationNumber") String registrationNumber);

    @Query("""
        SELECT a FROM Asset a
        WHERE a.owner = :farmer
        AND a.leasedTo is NULL
    """)
    List<Asset> findAvailableAssetsByOwner(@Param("farmer") Farmer farmer);
}
