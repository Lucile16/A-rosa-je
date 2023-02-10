<template>
  <div class="container text-center">
    <h1>{{ plante.nom }}</h1>
    <div class="container mt-3">
      <div class="row">
        <div class="col">
          <img
            src="../assets/img/rose4.jpg"
            alt="Plante"
            width="550"
            height="400"
          />
        </div>
        <div class="col">
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
