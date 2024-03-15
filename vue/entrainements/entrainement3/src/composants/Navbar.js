const navbar =  {

    props: ['links'],

    template: `
      <nav>
        <ul>
          <li v-for="link in links" :key="link.name">
            <a :href="link.url">{{ link.name }}</a>
          </li>
        </ul>
      </nav>
    `
  };
  