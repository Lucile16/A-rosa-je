<template>
  <div class="card" style="width: 18rem">
    <img src="../assets/img/logo.png" class="card-img-top" alt="..." />
    <div class="card-body">
      <h5 class="card-title">{{ title }}</h5>
      <p class="card-text">
        {{ description }}
      </p>
      <a href="`annonces/{{ id }}`" class="btn goto">Voir l'annonce</a>
    </div>
  </div>
</template>

<script>
export default {
  name: "AnnonceCardComponent",
  props: {
    title: String,
    description: String,
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
  margin-block: 10px;
}

.card .goto:hover,
.card .goto:focus {
  background-color: var(--color-secondary);
  border: var(--border-3);
}
</style>
