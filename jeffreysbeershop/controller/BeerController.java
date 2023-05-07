package com.finalproject.jeffreysbeershop.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.finalproject.jeffreysbeershop.entity.Beer;
import com.finalproject.jeffreysbeershop.entity.BeerStyle;
import com.finalproject.jeffreysbeershop.entity.BeerType;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/Beers")
@OpenAPIDefinition(info = @Info(title = "Jeffrey's Beer Shop"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})

public interface BeerController {
  // @formatter:off 
  @Operation( // Just to create a simple beer list e.g Corona Extra, Bud Light, Blue Moon...
      summary = "Returns a list of beers",
      description = "Returns a list of beers given the beer name",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A list of beers is returned.", 
              content = @Content(
                  mediaType = "application/json", 
              schema = @Schema(implementation = Beer.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No beers were found with the input criteria.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred.", 
              content = @Content(
                  mediaType = "application/json"))
      },
      
      parameters = {
          @Parameter(
              name = "beerId", 
              allowEmptyValue = false, 
              required = false, 
              description = "The beer name (i.e., 'Corona_Extra')"),      
      }
      )

  // Get method (READ)
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Beer> fetchBeers(
      @RequestParam(required = false)
      String beerId);
      
   @Operation( // Create a beer based on beer type and beer style e.g. Lager, American... 
       summary = "Creates a beer",
       description = "Create a pie using a required beer type and beer style",
       responses = {
           @ApiResponse(
               responseCode = "200", 
               description = "A beer is created!", 
               content = @Content(
                   mediaType = "application/json", 
               schema = @Schema(implementation = Beer.class))),
           @ApiResponse(
               responseCode = "400", 
               description = "The request parameters are invalid.", 
               content = @Content(
                   mediaType = "application/json")),
           @ApiResponse(
               responseCode = "404", 
               description = "Unable to create beer with the input criteria.", 
               content = @Content(
                   mediaType = "application/json")),
           @ApiResponse(
               responseCode = "500", 
               description = "An unplanned error occurred.", 
               content = @Content(
                   mediaType = "application/json"))
       },
       parameters = {
           @Parameter(
               name = "beerId", 
               allowEmptyValue = false, 
               required = false, 
               description = "The beer name (i.e., 'Corona Extra')"), 
           @Parameter(
               name = "beerType",
               allowEmptyValue = false,
               required = false,
               description = "The beer type (i.e., 'Lager')"),
           @Parameter(
               name = "beerStyle",
               allowEmptyValue = false,
               required = false,
               description = "The beer style (i.e., 'American')")
       }
   )
   
   // Post method (CREATE) 
   @PostMapping 
   @ResponseStatus(code = HttpStatus.CREATED)
   Optional<Beer> createBeers(
     @RequestParam(required = false) 
     String beerId,
     @RequestParam(required = false)
     BeerType beerType,
     @RequestParam(required = false)
     BeerStyle beerStyle); 
   
   @Operation( // Update the beer based on based beer style and beer type will remain the same. 
       summary = "Updates a beer",
       description = "Update a beer using a required beer name, beer type, and beer style",
       responses = {
           @ApiResponse(
               responseCode = "200", 
               description = "A beer is updated!", 
               content = @Content(
                   mediaType = "application/json", 
               schema = @Schema(implementation = Beer.class))),
           @ApiResponse(
               responseCode = "400", 
               description = "The request parameters are invalid.", 
               content = @Content(
                   mediaType = "application/json")),
           @ApiResponse(
               responseCode = "404", 
               description = "Unable to update beer with the input criteria.", 
               content = @Content(
                   mediaType = "application/json")),
           @ApiResponse(
               responseCode = "500", 
               description = "An unplanned error occurred.", 
               content = @Content(
                   mediaType = "application/json"))
       },
       parameters = {
           @Parameter(
               name = "beerId", 
               allowEmptyValue = false, 
               required = false, 
               description = "The beer name (i.e., 'Corona Extra')"), 
           @Parameter(
               name = "beerType",
               allowEmptyValue = false,
               required = false,
               description = "The beer type (i.e., 'Lager')"),
           @Parameter(
               name = "beerStyle",
               allowEmptyValue = false,
               required = false,
               description = "The beer style (i.e., 'American')")
       }
   )
 
   // Put method (UPDATE)
   @PutMapping
   @ResponseStatus(code = HttpStatus.OK)
   Optional<Beer> updateBeers (
       @RequestParam(required = false) 
       String beerId,
       @RequestParam(required = false)
       BeerType beerType,
       @RequestParam(required = false)
       BeerStyle newBeerStyle);

   @Operation (summary = "Deletes a beer",
       description = "Delete a beer given a required beer and beer type",
       responses = {
           @ApiResponse(
               responseCode = "200", 
               description = "A beer is deleted.", 
               content = @Content(
                   mediaType = "application/json", 
               schema = @Schema(implementation = Beer.class))),
           @ApiResponse(
               responseCode = "400", 
               description = "The request parameters are invalid.", 
               content = @Content(
                   mediaType = "application/json")),
           @ApiResponse(
               responseCode = "404", 
               description = "No beers were found with the input criteria.", 
               content = @Content(
                   mediaType = "application/json")),
           @ApiResponse(
               responseCode = "500", 
               description = "An unplanned error occurred.", 
               content = @Content(
                   mediaType = "application/json"))
       },
       parameters = {
           @Parameter(
               name = "beerId", 
               allowEmptyValue = false, 
               required = false, 
               description = "The beer name (i.e., 'Corona Extra')"), 
           @Parameter(
               name = "beerType",
               allowEmptyValue = false,
               required = false,
               description = "The beer type (i.e., 'Lager')") 
       }
     )
   // Delete method (DELETE)
   @DeleteMapping
   @ResponseStatus(code = HttpStatus.OK)
   Optional<Beer> deletePies(
       @RequestParam(required = false) 
       String beerId,
       @RequestParam(required = false)
       BeerType beerType);
   // @formatter:on
}
