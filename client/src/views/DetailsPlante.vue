<template>
  <PlanteCard :plante="plante" />
</template>

<script>
import PlanteCard from "../components/PlanteComponent.vue";
import axios from "axios";
export default {
  name: "DetailsPlante",
  components: {
    PlanteCard,
  },
  data() {
    return {
      plante: {},
    };
  },
  created: function () {
    this.fetchPlante();
  },
  methods: {
    fetchPlante: async function () {
      try {
        const response = await axios.get("http://localhost:8080/plantes");
        if (response.data._embedded.plantes !== null || !response.data._embedded.plantes.length) {
          this.plante = response.data._embedded.plantes[this.$route.params.id];
        }
      } catch (error) {
        console.log(error);
      }
    },
  },
};
</script>

<style></style>
