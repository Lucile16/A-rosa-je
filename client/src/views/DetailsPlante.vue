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
        console.log(response.data._embedded.plantes);
        this.plante = response.data._embedded.plantes[this.$route.params.id];
        //console.log(this.plante.data)
        console.log("ok");
        // console.log(self.commits[0].html_url);
      } catch (error) {
        console.log(error);
      }
    },
  },
};
</script>

<style></style>
