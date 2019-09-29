import React, { Component } from 'react'

export default class About extends Component {
  render() {
    return (
      <div>
        <section className="colorlib-about" data-section="about">
        <div className="colorlib-narrow-content">
            <div className="row">
            <div className="col-md-12">
                <div className="row row-bottom-padded-sm animate-box" data-animate-effect="fadeInLeft">
                <div className="col-md-12">
                    <div className="about-desc">
                    <span className="heading-meta">Resumen</span>
                    <h2 className="colorlib-heading">¿Quien soy?</h2>
                    <p>Soy un ingeniero de telecomunicaciones que lleva 20 años trabajando como desarrollador. </p>
                    <p>Estudie en la universidad de Málaga, y he trabajado en Madrid desde el 2000 al 2014, que volví a Málaga.</p>
                    <p>Casi siempre he trabajado con java. Y he trabajado mucho tiempo en banca. Estuve trabajando para el Santander 3 años en Inglaterra.</p>
                    </div>
                </div>
                </div>
            </div>
            </div>
        </div>
        </section>
        <section className="colorlib-about">
        <div className="colorlib-narrow-content">
            <div className="row">
            <div className="col-md-6 col-md-offset-3 col-md-pull-3 animate-box" data-animate-effect="fadeInLeft">
                <span className="heading-meta">Conocimientos</span>
                <h2 className="colorlib-heading">¿En que he trabajado?</h2>
            </div>
            </div>
            <div className="row row-pt-md">
            <div className="col-md-4 text-center animate-box">
                <div className="services color-1">
                <span className="icon">
                    <i className="icon-bulb" />
                </span>
                <div className="desc">
                    <h3>Desarrollo Web</h3>
                    <p>Tengo experiencia en la construccion de Aplicaciones web usando Java, JavaScript, React, HTML, CSS, PHP</p>
                </div>
                </div>
            </div>
            <div className="col-md-4 text-center animate-box">
                <div className="services color-3">
                <span className="icon">
                    <i className="icon-data" />
                </span>
                <div className="desc">
                    <h3>Big Data</h3>
                    <p>He trabajado 1 año con Haddop para el Deutsche Bank.</p>
                </div>
                </div>
            </div>
            <div className="col-md-4 text-center animate-box">
                <div className="services color-5">
                <span className="icon">
                    <i className="icon-phone3" />
                </span>
                <div className="desc">
                    <h3>Microsoft Net</h3>
                    <p>Aunque la mayoria de mi experiencia es en Java, tambien he desarrollado con Net (En Anovo, y en el Santander).</p>
                </div>
                </div>
            </div>
            </div>
        </div>
        </section>
      </div>
    )
  }
}
