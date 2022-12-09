package com.example.kinogospring.repository.querydslimpl;

import com.example.kinogospring.model.entity.CastCrew;
import com.example.kinogospring.model.entity.QCastCrew;
import com.example.kinogospring.repository.querydsl.CastCrewDao;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CastCrewDaoImpl implements CastCrewDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<CastCrew> findCastCrewByNameQueryDSL(String firstname) {
        final JPAQuery<CastCrew> query = new JPAQuery<>(em);
        final QCastCrew castCrew = QCastCrew.castCrew;

        return query.from(castCrew).where(castCrew.name.eq(firstname)).fetch();
    }

    @Override
    public List<CastCrew> findCastCrewsByNameAndAgeQueryDSL(String firstname, int age) {
        final JPAQuery<CastCrew> query = new JPAQuery<>(em);
        final QCastCrew castCrew = QCastCrew.castCrew;

        return query.from(castCrew).where(castCrew.name.eq(firstname).and(castCrew.age.eq(age))).fetch();

    }
}
