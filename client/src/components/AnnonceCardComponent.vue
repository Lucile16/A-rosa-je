<template>
  <div class="card m-4" style="width: 18rem">
    <img
      src="../assets/img/rose0.jpg"
      class="card-img mt-4 img-fluid"
      alt="image de notre annonce"
    />
    <div class="card-body">
      <h5 class="card-title">{{ annonce.titre }}</h5>
      <p class="card-text">
        {{ annonce.description }}
      </p>
      <router-link :to="`/annonce/${id}`" class="btn goto"
        >Voir l'annonce</router-link
      >
    </div>
  </div>
</template>

<script>
export default {
  name: "AnnonceCardComponent",
  props: {
    annonce: null,
  },
  computed: {
    id() {
      return this.annonce._links.self.href.split("/")[4];
    },
  },
};
</script>

<style scoped>
.card {
  border: var(--border-3);
}

.card > img {
  width: 80%;
  margin: 0 auto;
}
.card .goto {
  background-color: var(--color-primary);
  color: var(--color-font-light);
  margin-block: 10px;
}

.card .goto:hover,
.card .goto:focus {
  background-color: var(--color-secondary);
  color: var(--color-font-light);
}
</style>
