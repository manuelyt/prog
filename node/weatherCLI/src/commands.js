'use strict'

const fetch = require('node-fetch')


const APIXU_KEY = '917e75b6b2894f9e95c55e5a0c558666'
//const APIXU_KEY = '<YOUR APIXU KEY>'

const fetchNow = async city => {
  const response = await fetch(
    `http://api.weatherstack.com/current?access_key=${APIXU_KEY}&query=${city}`
//    `https://api.apixu.com/v1/current.json?key=${APIXU_KEY}&q=${city}`
  )

  const data = await response.json()

  //const now2 = await response.json()

  const now = {
    location: data.location.name,
    country: data.location.country,
    longitude: data.location.lon,
    latitude: data.location.lat,
    temparature: data.current.temperature,
    condition: data.current.weather_descriptions
  }
  
  console.log(now)
}

const weatherForecast = async city => {
  const response = await fetch(
    `http://api.weatherstack.com/forecast?access_key=${APIXU_KEY}&query=${city}`
//    `https://api.apixu.com/v1/forecast.json?key=${APIXU_KEY}&q=${city}`
  )
  const data = await response.json()

  console.log(data.forecast)
}

// export all methods
module.exports = {
  fetchNow,
  weatherForecast
}
