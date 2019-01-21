# countriesAndContinent
The Spring project provide rest-api to search for any country and return its continent.


http://localhost:8080/countries/Italy

{
    "code": "IT",
    "name": "Italy",
    "fullName": "Italian Republic",
    "iso3": "ITA",
    "number": "380",
    "continentCode": {
        "code": "EU",
        "name": "Europe"
    }
}


-------------------------------------------
http://localhost:8080/countries/France
{
    "code": "FR",
    "name": "France",
    "fullName": "French Republic",
    "iso3": "FRA",
    "number": "250",
    "continentCode": {
        "code": "EU",
        "name": "Europe"
    }
}

--------------------------------------------

Get all countries by using the following url, result will be retrieved paginated by 10 and sorted Asc.
Example page=0:
http://localhost:8080/countries?page=0
{
    "content": [
        {
            "code": "AF",
            "name": "Afghanistan",
            "fullName": "Islamic Republic of Afghanistan",
            "iso3": "AFG",
            "number": "004",
            "continentCode": {
                "code": "AS",
                "name": "Asia"
            }
        },
        {
            "code": "AL",
            "name": "Albania",
            "fullName": "Republic of Albania",
            "iso3": "ALB",
            "number": "008",
            "continentCode": {
                "code": "EU",
                "name": "Europe"
            }
        },
        {
            "code": "DZ",
            "name": "Algeria",
            "fullName": "People's Democratic Republic of Algeria",
            "iso3": "DZA",
            "number": "012",
            "continentCode": {
                "code": "AF",
                "name": "Africa"
            }
        },
        {
            "code": "AS",
            "name": "American Samoa",
            "fullName": "American Samoa",
            "iso3": "ASM",
            "number": "016",
            "continentCode": {
                "code": "OC",
                "name": "Oceania"
            }
        },
        {
            "code": "AD",
            "name": "Andorra",
            "fullName": "Principality of Andorra",
            "iso3": "AND",
            "number": "020",
            "continentCode": {
                "code": "EU",
                "name": "Europe"
            }
        },
        {
            "code": "AO",
            "name": "Angola",
            "fullName": "Republic of Angola",
            "iso3": "AGO",
            "number": "024",
            "continentCode": {
                "code": "AF",
                "name": "Africa"
            }
        },
        {
            "code": "AI",
            "name": "Anguilla",
            "fullName": "Anguilla",
            "iso3": "AIA",
            "number": "660",
            "continentCode": {
                "code": "NA",
                "name": "North America"
            }
        },
        {
            "code": "AQ",
            "name": "Antarctica",
            "fullName": "Antarctica (the territory South of 60 deg S)",
            "iso3": "ATA",
            "number": "010",
            "continentCode": {
                "code": "AN",
                "name": "Antarctica"
            }
        },
        {
            "code": "AG",
            "name": "Antigua and Barbuda",
            "fullName": "Antigua and Barbuda",
            "iso3": "ATG",
            "number": "028",
            "continentCode": {
                "code": "NA",
                "name": "North America"
            }
        },
        {
            "code": "AR",
            "name": "Argentina",
            "fullName": "Argentine Republic",
            "iso3": "ARG",
            "number": "032",
            "continentCode": {
                "code": "SA",
                "name": "South America"
            }
        }
    ],
    "totalPages": 25,
    "totalElements": 249,
    "last": false,
    "size": 10,
    "number": 0,
    "sort": [
        {
            "direction": "ASC",
            "property": "name",
            "ignoreCase": false,
            "nullHandling": "NATIVE",
            "ascending": true,
            "descending": false
        }
    ],
    "numberOfElements": 10,
    "first": true
}
