<template>
  <div class="container text-center">
    <h1>{{ plante.nom }}</h1>
    <div class="container mt-3">
      <div class="row justify-content-center">
        <img
          src="../assets/img/rose4.jpg"
          alt="Plante"
          width="550"
          height="400"
        />
        <ul class="list-unstyled">
          <li>Famille de la plante : {{ plante.famille }}</li>
          <li>Dimension de la plante : {{ plante.dimension }}</li>
          <li>Exposition de la plante : {{ plante.exposition }}</li>
          <li>Arrosage de la plante : {{ plante.arrosage }}</li>
          <li>Description de la plante : {{ plante.description }}</li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "PlanteCard",
  props: {
    plante: null,
  },
  data() {
    return {};
  },
};
</script>

<style scoped>
li {
  color: var(--color-secondary);
}
@media (max-width: 991.98px) {
  img {
    height: 40vh;
    width: 65vw;
    margin-bottom: 20px;
  }
}
@media (max-width: 750px) {
  img {
    height: 20vh;
    width: 40vw;
    margin-bottom: 20px;
  }
}
@media (max-width: 650px) {
  img {
    height: 20vh;
    width: 50vw;
    margin-bottom: 20px;
  }
}
@media (max-width: 500px) {
  img {
    height: 20vh;
    width: 60vw;
    margin-bottom: 20px;
  }
}
@media (max-width: 400px) {
  img {
    height: 20vh;
    width: 50vw;
    margin-bottom: 20px;
  }
}
@media (max-width: 350px) {
  img {
    height: 22vh;
    width: 70vw;
    margin-bottom: 20px;
  }
}
@media (max-width: 250px) {
  img {
    height: 15vh;
    width: 80vw;
    margin-bottom: 20px;
  }
}
</style>
