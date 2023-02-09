import { createRouter, createWebHashHistory } from "vue-router";
import ListeAnnonces from "../views/ListeAnnonces.vue";
import DetailsPlante from "../views/DetailsPlante";
import DetailsAnnonce from "../views/DetailsAnnonce";
import CreerAnnonce from "../views/CreerAnnonce.vue";
import NotFound from "../views/NotFound.vue";

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
  {
    path: "/creer",
    name: "creerAnnonce",
    component: CreerAnnonce,
  },
  {
    path: "/:pathMatch(.*)*",
    name: "Default",
    component: NotFound,
  },
];

const router = createRouter({
  history: createWebHashHistory(),
  routes,
});

export default router;
