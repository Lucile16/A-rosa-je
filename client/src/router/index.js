import { createRouter, createWebHashHistory } from "vue-router";
import ListeAnnonces from "../views/ListeAnnonces.vue";
import DetailsPlante from "../views/DetailsPlante";
import CreerAnnonce from "../views/CreerAnnonce.vue";

const routes = [
  {
    path: "/",
    name: "home",
    component: ListeAnnonces,
  },
  {
    path: "/plante/:id",
    name: "plante",
    component: DetailsPlante,
  },
  {
    path: "/creer",
    name: "creerAnnonce",
    component: CreerAnnonce,
  }
];

const router = createRouter({
  history: createWebHashHistory(),
  routes,
});

export default router;
