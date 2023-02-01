import { createRouter, createWebHashHistory } from "vue-router";
import ListeAnnonces from "../views/ListeAnnonces.vue";
import PlantePage from "../views/PlantePage";

const routes = [
  {
    path: "/",
    name: "home",
    component: ListeAnnonces,
  },
  {
    path: "/plante/:id",
    name: "plante",
    component: PlantePage,
  }
];

const router = createRouter({
  history: createWebHashHistory(),
  routes,
});

export default router;