<template>
  <div class="container text-center">
    <h1>{{ plante.nom }}</h1>
    <div class="container">
      <div class="row">
        <div class="col">
          <img
            src="https://media.istockphoto.com/photos/young-plant-growing-in-sunlight-picture-id658291850?b=1&k=20&m=658291850&s=612x612&w=0&h=a0XOE6YCZQeeoOesqPfZPVBVRzJLENkjfIoYCSi-a1g="
            alt="Plante"
          />
        </div>
        <div class="col">
          <div>Famille de la plante : {{ plante.famille }}</div>
          <div>Dimension de la plante : {{ plante.dimension }}</div>
          <div>Exposition de la plante : {{ plante.exposition }}</div>
          <div>Arrosage de la plante : {{ plante.arrosage }}</div>
          <div>Description de la plante : {{ plante.description }}</div>
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
