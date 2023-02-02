import { createRouter, createWebHashHistory } from "vue-router";
import ListeAnnonces from "../views/ListeAnnonces.vue";
import DetailsPlante from "../views/DetailsPlante";
import DetailsAnnonce from "../views/DetailsAnnonce";

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
    path: "/annonce/:id",
    name: "annonce",
    component: DetailsAnnonce,
  },
];

const router = createRouter({
  history: createWebHashHistory(),
  routes,
});

export default router;
