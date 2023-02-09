<template>
  <div class="container text-center">
    <h1>{{ plante.nom }}</h1>
    <div class="container">
      <div class="row align-items-center">
        <div class="col gx-5">
          <img v-bind:src="plante.photo" alt="Plante" />
        </div>
        <div class="col gx-5">
          <div>Famille de la plante : {{ plante.famille }}</div>
          <div>Dimension de la plante : {{ plante.dimension }}</div>
          <div>Exposition de la plante : {{ plante.exposition }}</div>
          <div>Arrosage de la plante : {{ plante.arrosage }}</div>
          <div>Description de la plante : {{ plante.description }}</div>
          <div>Description de la plante : {{ plante.photo }}</div>
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
