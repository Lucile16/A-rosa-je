<template>
  <div class="annonce_component">
    <h1 class="mb-4">{{ annonce.titre }}</h1>
    <div class="d-flex justify-content-center mb-5">
      <div class="card" style="max-width: 540px; border-color: var(--color-background); background-color: var(--color-background);">
        <div class="row g-4">
          <div class="col-md-6">
            <img
              src="../assets/img/rose0.jpg"
              class="img-fluid rounded-start"
              alt="image_plante_annonce"
            />
          </div>
          <div class="col-md-6">
            <div class="card-body">
              <h5 class="card-title">Description :</h5>
              <p class="card-text fw-normal">{{ annonce.description }}</p>
            </div>
          </div>
        </div>
      </div>
    </div>

    <h3 class="mb-4">Liste des plantes</h3>
    <div class="d-flex justify-content-evenly">
      <a href="#"><img src="../assets/img/rose1.jpg" alt="image_rose1"/></a>
      <a href="#"><img src="../assets/img/rose2.jpg" alt="image_rose2"/></a>
      <a href="#"><img src="../assets/img/rose3.jpg" alt="image_rose3"/></a>
    </div>

    <p class="mt-4">
      <small><i>Etat et createur : {{annonce.etat}} par ?</i></small>
    </p>
  </div>
</template>

<script>
export default {
  name: "AnnonceComponent",
  props: {
    annonce: null
  },
};
</script>

<style scoped>
img {
  width : 100vw;
  height : 25vh;
  max-width : 200px;
  max-height : 150px;
}
</style>
