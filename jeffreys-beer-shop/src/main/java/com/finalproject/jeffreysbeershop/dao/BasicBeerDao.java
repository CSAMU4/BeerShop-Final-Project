package com.finalproject.jeffreysbeershop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.finalproject.jeffreysbeershop.entity.Beer;
import com.finalproject.jeffreysbeershop.entity.BeerStyle;
import com.finalproject.jeffreysbeershop.entity.BeerType;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BasicBeerDao implements BeerDao {
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;


  @Override
  public List<Beer> fetchBeers(String beerId) {
    log.info("DAO: beerID={}", beerId);

    //@formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM beers "
        + "WHERE beer_id = :beer_id";
    //@formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("beer_id", beerId);

    return jdbcTemplate.query(sql, params, new RowMapper<>() {

      // Mapping every column name to corresponding instance variables within Beer table
      @Override
      public Beer mapRow(ResultSet rs, int rowNum) throws SQLException {
        //@formatter:off
        return Beer.builder()
            .beerPK(rs.getLong("beer_pk"))
            .beer_id(new String(rs.getString("beer_id")))
            .build();
        //@formatter:on
      }
    });
  }

  @Override
  public Optional<Beer> createBeers(String beerId, BeerType beerType, BeerStyle beerStyle) {
    log.info("DAO: beerID={}, beerType={}", beerId, beerType, beerStyle);

    //@formatter:off
    String sql = ""
        + "INSERT INTO beers ("
        + "beer_id, beer_type, beer_style"
        + ") VALUES ("
        +  ":beer_id, :beer_type, :beer_style)";
    //@formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("beer_id", beerId);
    params.put("beer_type", beerType.toString());
    params.put("beer_style", beerStyle.toString());

    jdbcTemplate.update(sql, params);
    return Optional.ofNullable(
        Beer.builder().beer_id(beerId).beer_type(beerType).beer_style(beerStyle).build());
  }

  @Override
  public Optional<Beer> updateBeers(String beerId, BeerType beerType, BeerStyle newBeerStyle) {
    log.info("DAO: beerID={}, beerType={}", beerId, beerType, newBeerStyle);

    //@formatter:off
    String sql = ""
        + "UPDATE beers SET beer_style = :new_beer_Style"
        + "WHERE beer_id = :beer_id AND beer_type = :beer_type";
    
    //@formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("beer_id", beerId);
    params.put("beer_style", beerType.toString());
    params.put("new_beer_style", newBeerStyle.toString());

    jdbcTemplate.update(sql, params);
    return Optional.ofNullable(Beer.builder().beer_id(beerId).beer_style(newBeerStyle).build());
  }

  @Override
  public Optional<Beer> deleteBeers (String beerId, BeerType beerType) {
    //@formatter:off
    String sql = ""
        + "DELETE FROM beers WHERE "
        + "beer_id = :beer_id AND "
        + "beer_type = :beer_type";
    //@formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("beer_id", beerId);
    params.put("beer_type", beerType.toString());

    jdbcTemplate.update(sql, params);
    
    return Optional.ofNullable(Beer.builder().beer_id(beerId).beer_type(beerType).build());
  }
}
