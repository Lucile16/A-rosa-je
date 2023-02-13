<template>
  <div class="annonce_component">
    <h1 class="mb-4">{{ annonce.titre }}</h1>
    <div class="d-flex justify-content-center mb-5">
      <div
        class="card"
        style="
          max-width: 540px;
          border-color: var(--color-background);
          background-color: var(--color-background);
        "
      >
        <div class="row g-4">
          <div class="col-md-6">
            <router-link
              :to="`/plantes/${
                this.plantes[0]._links.self.href.split('/')[4] - 1
              }`"
            >
              <img
                src="../assets/img/Fleur.png"
                class="img-fluid rounded-start"
                alt="image_plante_annonce"
              />
            </router-link>
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

    <h3 class="mb-4">Catalogue des botanistes</h3>
    <div class="d-flex justify-content-evenly">
      <router-link
        :to="`/plantes/${this.plantes[0]._links.self.href.split('/')[4] - 1}`"
        ><img src="../assets/img/rose1.jpg" alt="image_rose1"
      /></router-link>
      <img src="../assets/img/rose2.jpg" alt="image_rose2" />
      <img src="../assets/img/rose3.jpg" alt="image_rose3" />
    </div>

    <p class="mt-4">
      <small
        ><i>Etat et créateur : {{ annonce.etat }} par ?</i></small
      >
    </p>
  </div>
</template>

<script>
export default {
  name: "AnnonceComponent",
  props: {
    annonce: null,
    plantes: null,
  },
};
</script>

<style scoped>
.card > img {
  width: 80%;
  margin: 0 auto;
}
img {
  width: 100vw;
  height: 16vh;
  max-width: 200px;
  max-height: 150px;
}
</style>
