package com.Bootcamp2020Project.Project.Repositories;

import com.Bootcamp2020Project.Project.Entities.VerificationToken;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationTokenRepository extends CrudRepository<VerificationToken,Long> {

    @Query(value = "select tokenId, generatedDate, token, userEmail from VerificationToken where token=:token",nativeQuery = true)
    VerificationToken getByToken(@Param("token") String token);
}
