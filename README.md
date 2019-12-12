# Food Management Java
A Java Project!  
感谢 https://github.com/k33ptoo 
## Licence  

<html>
  <head>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/css?family=Nunito+Sans|Roboto+Condensed" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.2/css/all.css" integrity="sha384-/rXc/GQVaYpyDdyxK+ecHPVYJSN9bmVFBvjA/9eOB+pb3F2w2N6fc5qB9Ew5yIns" crossorigin="anonymous">
    <style>
      .card {
        display: block;
        text-decoration: none;
        padding: 20px;
        box-shadow: 0 1px 2px rgba(85, 104, 130, 0.1);
        border: 1px solid rgba(85, 104, 130, 0.1);
        border-radius: 3px;
        margin-bottom: 25px;
        background: #fff;
        position: relative;
      }
      .fossa-logo {
        text-align:center;
        margin:20px 0;
      }
      @font-face {
          font-family: 'Blender';
          src: url('/font/blenderpro-medium-webfont.woff') format('woff');
          font-weight: 400;
          font-style: normal
      }

      @font-face {
          font-family: 'Blender';
          src: url('/font/blenderpro-bold-webfont.woff') format('woff');
          font-weight: 700;
          font-style: normal
      }
      @font-face {font-family: 'DIN';font-weight: normal;font-style: normal;src: url('/font/DINNextLTPro-Regular.eot');src: url('/font/DINNextLTPro-Regular.eot?#iefix') format('embedded-opentype'),url('/font/DINNextLTPro-Regular.woff2') format('woff2'),url('/font/DINNextLTPro-Regular.woff') format('woff'),url('/font/DINNextLTPro-Regular.ttf') format('truetype');}
      @font-face {font-family: 'DIN';font-weight: bold;font-style: normal;src: url('/font/DINNextLTPro-Medium.eot');src: url('/font/DINNextLTPro-Medium.eot?#iefix') format('embedded-opentype'),url('/font/DINNextLTPro-Medium.woff2') format('woff2'),url('/font/DINNextLTPro-Medium.woff') format('woff'),url('/font/DINNextLTPro-Medium.ttf') format('truetype');}
      h1 {
        font-family: 'Blender', 'Roboto Condensed', 'Open Sans', 'Arial', sans-serif;
        color: #2a3646;
      }
      h2 {
        font-family: 'Blender', 'Roboto Condensed', 'Open Sans', 'Arial', sans-serif;
        color: #2a3646;
        padding-top: 0px;
        margin-top: 5px;
      }
      h3 {
        font-family: 'Blender', 'Roboto Condensed', 'Open Sans', 'Arial', sans-serif;
        color: #556882;
      }
      a {
        font-family: 'DIN', 'Nunito Sans' 'Helvetica Neue', Helvetica, Arial, sans-serif;
        color: #3479be;
      }
      b { color: #2a3646; }
      td { word-wrap: break-word; }
      body {
        background: #fafafa;
        font-family: 'DIN', 'Nunito Sans' 'Helvetica Neue', Helvetica, Arial, sans-serif;
        color: #556882;
      }
      table {
        margin-top: 20px;
      }

      header.card {
        border: solid 1px #556882;
        padding-bottom: 35px;
        margin-top: 25px;
      }
    </style>
  </head>
  <body>
    <div class="container">
      <header class="card">
        <div class="row">
          <div class="col-md-2">
            <div class="fossa-logo">
              
              <svg width="100px" height="100px" viewBox="0 0 314 367" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:sketch="http://www.bohemiancoding.com/sketch/ns">
                  <title>FOSSA Flat Logo</title>
                  <defs></defs>
                  <g id="Page-1" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd" sketch:type="MSPage">
                      <g id="Fossa-Flat" sketch:type="MSLayerGroup" fill="#2a3646">
                          <path d="M31.3,195.6 C31.3,195.6 30.8,194.2 32.2,193.1 C34,191.8 36.3,190.5 37.6,192 L37.7,192.1 L37.7,192.1 L37.8,192.2 L37.8,192.2 L37.8,192.2 C38.8,193.3 40,193.7 41.2,193.7 C43.8,193.7 46.5,191.9 47.7,191.1 C50.6,189.1 52.6,187.4 53,182.2 L53,182 C53,181.9 53,180.4 54.3,180.1 C54.8,180 55.3,180.3 55.7,180.6 C56.7,181.5 57.9,183.7 57.7,186.9 C57.3,191.6 55,195.8 50.9,199.4 C50.6,199.7 50.3,199.9 50,200.2 C47.5,202.2 45.1,204 42.9,205.5 C39.8,207.2 37,204.6 35.6,202.9 C35,202.1 34.5,201.4 33.7,200.2 L33.5,199.8 C32.7,198.4 31.9,197 31.3,195.6 L31.3,195.6 L31.3,195.6 Z M21.3,225.9 C21.6,226.1 21.9,226.3 22.2,226.5 C22.6,226.8 23,227 23.5,227.2 C24.6,227.7 25.7,227.5 27.6,227 C28.1,226.9 28.6,226.8 29.1,226.7 C26.7,224.5 24.9,221.9 23.6,219 C23.5,221.3 22.9,223.7 21.3,225.9 L21.3,225.9 Z M49.7,48.8 C49.7,48.7 49.6,48.7 49.7,48.8 C48.5,47.3 47.5,45.8 46.7,44.3 C47,47 47.5,49.7 48,52.1 C48.2,53 48.3,53.8 48.5,54.6 C49.4,53.6 50.3,52.7 51.1,51.8 C50.6,49.8 49.7,48.8 49.7,48.8 L49.7,48.8 Z M6.4,203.4 C6.5,203.2 6.5,202.9 6.5,202.5 L6.5,202.2 C6.4,201.1 6.5,200 6.6,198.7 C6.7,197.1 7,195.6 7.4,194 L7.4,194 C7.4,193.9 7.4,193.8 7.5,193.7 C7.6,193.4 7.7,192.7 7.6,192.5 L7.6,192.5 C6.4,191.6 5,190.8 4,190.3 C4.2,192.6 4.1,195.1 4,196.5 L4,196.9 L4,197.1 L4,197.2 C3.9,198.7 3.8,200.4 6.1,202.9 C6.1,203.1 6.3,203.2 6.4,203.4 L6.4,203.4 Z M228.9,99.7 C230.1,99.7 231.3,99.6 232.5,99.4 C234.4,98.8 235.7,98.5 235.9,98.4 C246.4,95.3 255.1,88.6 259.1,80.5 C261.9,73.2 261.6,67.6 261.3,63.6 C261.2,62.7 261.2,61.8 261.2,60.9 C261.1,53.9 269.8,41.7 271.6,39.2 C277.9,28.8 280,19.9 277.9,13.5 C276,7.8 271.3,5.9 271.2,5.8 L271.2,5.8 L271.1,5.8 C269.3,5 267.5,4.3 265.6,3.8 C262.6,3 259.4,2.6 256.1,2.6 C243,2.6 228.7,9.3 218,20.6 C218,20.7 217.9,20.8 217.8,20.9 C213.9,26 207.7,36.4 210.4,48.7 C212.3,57.1 216.9,63.7 224.5,69 C225.5,69.7 226,70.8 225.8,72 C225.6,73.2 224.9,74.1 223.8,74.5 C223.7,74.5 214.2,78.1 212.2,84.2 C211.4,86.6 211.9,89.2 213.8,92.1 C214.1,92.2 219.6,99.7 228.9,99.7 L228.9,99.7 L228.9,99.7 Z M20.4,172.2 C21.8,172.2 23.7,171.4 26.8,169.5 C31.1,166.9 35.4,165.2 39.7,164.5 L39.9,164.5 C41.3,164.2 42.3,163 42.3,161.5 L42.3,161.4 L42.3,161.2 C42.2,160.1 41.5,159.1 40.4,158.7 C40.3,158.7 40.2,158.6 40.1,158.6 C39,158.2 37.8,158 36.5,158 L36.4,158 C34.7,158 33.7,158.3 32.6,158.7 C31.7,159 30.9,159.2 29.9,159.2 L29.3,159.2 C28.4,159.1 27.5,158.8 26.9,158.5 C26.2,158.2 25.6,158 24.9,158 C24.6,158 24.4,158 24.1,158.1 C22.2,158.5 20.2,160.2 19.5,160.9 C19.5,160.9 19.4,161 19.3,161 L19.2,161 C18,162 16.7,163.1 15.4,164.1 L14.8,164.7 C14.8,164.7 14.7,164.8 14.7,164.9 L14.5,165.2 C14.3,165.6 14.2,166.1 14.2,166.5 C14.2,167.3 14.5,168.1 15.1,168.7 C15.2,168.8 15.3,168.9 15.4,169 L15.4,169 C15.5,169.1 15.6,169.2 15.7,169.3 C17.9,171.3 18.9,172.2 20.4,172.2 L20.4,172.2 L20.4,172.2 Z M167.6,353.7 C167.7,353.7 167.8,353.6 167.9,353.6 C182.9,347.6 197.6,340 211.6,330.9 L212.2,330.5 C213,329.9 213.6,329 213.6,328 L213.6,328 L213.6,327.9 L213.6,327.7 C213.6,327.5 213.6,327.4 213.5,327.2 C213.5,327.1 213.4,327 213.4,326.9 L213.3,326.7 C210.1,317.8 205.6,298.4 211.3,269.1 C212.8,261.6 213.6,254.4 213.7,247.7 L213.7,247.6 L213.7,247.3 L213.7,247.2 L213.7,247 C213.5,245.4 212.2,244.2 210.7,244.2 C209.7,244.2 208.8,244.7 208.3,245.4 L208.2,245.6 L208.2,245.7 L208,245.9 C206.4,248.9 204.4,252 202.1,255.3 C178.2,289.6 160.2,318.4 163.6,351.2 C163.8,352.8 165.1,353.9 166.6,353.9 C166.9,353.9 167.3,353.8 167.6,353.7 L167.6,353.7 Z M123,366.1 L123.5,366 C129.1,365.2 140.5,363.1 155.1,358.3 L155.1,358.3 L155.3,358.2 L155.4,358.2 C155.5,358.2 155.6,358.1 155.7,358.1 L155.7,358.1 C156.8,357.6 157.5,356.5 157.5,355.3 L157.5,355.3 L157.5,355.1 L157.4,354.7 C152.5,318.7 171.5,288.1 196.7,251.9 C212.8,228.8 208.5,217.6 203.8,211.2 C199.2,205.7 193.3,203 186.1,203 C182.8,203 179.2,203.6 175.4,204.8 C172.1,205.9 168.7,206.9 165.2,207.8 C161.7,208.6 158,209.3 154.2,209.9 C151.7,210.3 149.2,210.6 146.8,210.9 C134.4,212.5 122.6,214 108.8,221.2 L108.6,221.4 L108.4,221.4 C107.3,221.9 106.3,222.5 105.2,223 L105.2,223 L105.1,223 C105,223.1 104.8,223.1 104.7,223.2 L104.6,223.2 C104.3,223.4 104.1,223.6 103.9,223.9 C103.9,223.9 103.8,224 103.8,224.1 L103.8,224.2 L103.6,224.4 C103.4,224.8 103.3,225.3 103.3,225.7 C103.3,226.6 103.7,227.5 104.4,228.1 L105.1,228.1 L105.1,228.6 C114.4,234.4 121.1,248.7 122.1,265 C123.4,285.9 121.5,305.2 119.8,322.1 L119.8,322.3 C118,339.9 116.6,353.7 119.3,363.6 L119.3,363.7 L119.3,363.8 C119.3,364 119.4,364.3 119.5,364.5 C120,365.6 121.1,366.3 122.3,366.3 C122.8,366.1 122.9,366.1 123,366.1 L123,366.1 Z M38.6,64.5 C38.7,64.4 38.7,64.4 38.8,64.3 L38.8,64.3 L38.8,64.2 C40.2,62.5 41.5,60.9 42.8,59.5 C42.9,59.4 42.9,59.4 43,59.3 C43.4,58.8 43.7,58.1 43.7,57.4 L43.7,57.3 L43.7,57.1 L43.7,56.8 C43.5,55.6 43.3,54.3 43,53.2 C41.7,46.7 40.2,38.7 43,32.1 C43,28.6 43.6,25 44,21.8 L44,21.6 C44.3,19.7 44.6,17.8 44.8,15.9 C45.4,9.9 44.3,4.9 41.8,2.2 C40.4,0.7 38.7,1.42108547e-13 36.6,1.42108547e-13 L36.3,1.42108547e-13 C35.3,1.42108547e-13 33.9,1.42108547e-13 32.4,1.4 C31.4,2.6 30.6,4.9 30,7.8 C29.2,12 29.2,16.7 29.4,19.4 C30.4,29.5 30.2,30.8 29.4,33 C29,34 28.5,35.4 28.3,41.1 C28.1,45.4 29.9,51.4 31.7,57.1 L31.7,57.2 C32.3,59.1 32.9,61.1 33.4,63.1 L33.4,63.1 C33.4,63.2 33.5,63.4 33.5,63.5 L33.5,63.6 C34,64.8 35.1,65.6 36.4,65.6 C37.2,65.5 38,65.1 38.6,64.5 L38.6,64.5 Z M42.3,100.2 C42.3,100.1 42.4,99.9 42.4,99.8 L42.4,99.8 L42.4,99.7 C42.9,96.1 43.3,91.3 43.6,84.1 C43.7,82 44,79.7 44.4,77.4 L44.4,77.4 L44.7,76.1 C44.7,75.9 44.8,75.7 44.8,75.5 L44.8,75.4 L44.8,75.2 C44.6,73.6 43.3,72.4 41.8,72.4 C40.9,72.4 40,72.8 39.5,73.5 C39.5,73.5 39.4,73.6 39.4,73.7 L39.4,73.8 C38.3,75.2 37.6,76.1 37.4,76.3 L37.3,76.4 C36.3,77.5 35.4,78.9 34.6,80.5 C32.7,84.2 31.8,87.9 31.7,88.2 L31.7,88.3 C31.3,89.9 30.9,91.6 30.5,93.4 C30.5,94.5 30.8,95.5 31.4,96.5 C32.5,98.5 34.6,100.3 37.8,102.1 L37.9,102.2 C38,102.3 38.1,102.3 38.2,102.4 C38.6,102.6 39,102.7 39.5,102.7 C40.7,102.5 42,101.6 42.3,100.2 L42.3,100.2 Z M57,44.6 L57,44.6 L57.2,44.4 C60,42 63.1,39.9 66.6,38 L66.7,38 C67.7,37.5 68.2,36.4 68.2,35.3 L68.2,35.2 L68.2,35 C68.1,34.4 67.9,33.8 67.5,33.3 C64.2,29.4 61.6,24.1 59.4,19.4 L59.2,19 C58.5,17.6 57.8,16.2 57.2,14.9 L57.2,14.9 L57.2,14.9 L56.9,14.3 C56.4,13.3 55.3,12.6 54.2,12.6 C53.2,12.6 52.3,13.1 51.8,13.8 C51.8,13.8 51.7,13.9 51.7,14 L51.7,14.1 L51.5,14.3 C51.3,14.7 51.2,15 51.2,15.4 L51.1,16.4 C50.9,18.5 50.6,20.5 50.3,22.4 C49.8,25.9 49.3,29.2 49.3,32.4 C49.4,36.7 50.4,40.2 52.6,43.5 L52.6,43.6 C52.6,43.7 52.7,43.7 52.8,43.8 C53.4,44.6 54.3,45 55.3,45 C55.8,45.3 56.5,45 57,44.6 L57,44.6 Z M57.9,160.1 L57.9,160.1 C61.7,149.8 69,139.6 74.9,131.3 C77.3,127.9 79.7,124.7 81.3,122 C94.1,101.2 101.1,81.7 101.2,81.5 C101.2,81.4 101.3,81.3 101.3,81.2 C107.2,68 114.5,58.8 123.6,53 C131.6,47.9 140.9,45.2 153.7,44.3 L153.9,44.3 C158.5,44 162.2,42.8 164.9,40.6 L164.9,40.5 L165,40.5 L165.2,40.3 L165.3,40.3 C165.5,40.1 165.8,39.9 165.9,39.7 C166.3,39.2 166.6,38.5 166.6,37.8 L166.6,37.7 L166.6,37.5 C166.5,36.1 165.3,34.9 163.9,34.8 L163,34.7 C159.3,34.3 155.3,34.1 151,34.1 C142.2,34.1 132.3,35 122.5,36.7 C119.4,37.2 116.1,37.5 112.3,37.5 C109.3,37.5 106.4,37.3 103.5,37.2 C100.7,37.1 97.8,36.9 95,36.9 C93.8,36.9 92.8,36.9 91.8,37 C88.8,37.1 85.8,37.6 82.7,38.4 L82.7,38.4 L81.9,38.6 L81.8,38.6 C70.4,41.9 60.5,52 54.5,66.1 C54.5,66.1 54.5,66.2 54.4,66.2 C51.8,72.3 50.3,78.7 50,84.2 C49.3,98.2 48.5,104.3 46.3,110 L46.3,110.2 L46.1,110.4 C45.1,112.9 43.9,115.3 42.4,118.4 L42.1,119.1 C40,123.2 37.2,128 34.4,132.7 L33.6,134 C33.2,134.6 32.9,135.2 32.5,135.8 C30.1,139.9 27.7,144.1 26.2,147.3 L26.2,147.5 L26,147.7 C26,147.8 25.9,147.9 25.9,147.9 L25.9,147.9 C25.8,148.2 25.7,148.6 25.7,148.9 C25.7,150.2 26.5,151.3 27.6,151.7 C27.7,151.7 27.8,151.8 27.9,151.8 L28.1,151.9 C28.5,152.1 28.9,152.2 29.3,152.4 C29.5,152.5 29.8,152.6 29.9,152.6 C30.1,152.6 30.4,152.5 30.6,152.4 L30.7,152.4 C31.9,152 33.7,151.5 36.5,151.5 L36.6,151.5 C39.9,151.5 42.9,152.4 45.5,154 C47.5,155.3 50.2,157.8 52.8,160.8 C53.4,161.5 54.2,161.9 55.2,161.9 C56.3,162.1 57.4,161.3 57.9,160.1 L57.9,160.1 Z M66.6,192.2 L66.6,192.2 C66.8,192.2 66.9,192.1 67,192.1 L67.1,192.1 C73.7,190.5 79.1,188.6 82.5,180.6 C86.2,172 88.7,161.6 91.1,151.5 L91.9,148.3 C95.9,131.8 99.9,117.4 108.5,107.5 L108.6,107.4 C108.9,107 109.3,106.6 109.6,106.3 L109.6,106.3 C109.7,106.2 109.7,106.2 109.8,106.1 C109.9,106 109.9,106 110,105.9 C113.9,102.2 119.6,100.2 126.1,100.2 C129.3,100.2 132.6,100.7 136,101.6 L136,101.6 L136.1,101.6 C136.7,101.8 137.3,101.9 137.9,102.1 C141,103 144.6,104.1 148.4,104.1 L148.4,104.1 C151.8,104.1 154.9,103.3 158,101.5 L158,101.5 L158.1,101.5 C158.3,101.4 181.5,88.7 193.9,50.3 L193.9,50.2 C194,50 194,49.7 194.1,49.5 L194.1,49.5 L194.3,49 L194.3,48.9 L194.4,48.7 C194.5,48.4 194.6,48.2 194.7,47.9 L194.9,47.4 C195,47.1 195,46.9 195,46.6 L195,46.5 L195,46.3 C194.8,44.7 193.5,43.6 192,43.6 C191.4,43.6 190.9,43.8 190.4,44.1 L190.2,44.2 C181.9,49.7 173.5,50.2 164.2,50.3 C160.7,50.3 157.6,50.4 154.7,50.6 L154.5,50.6 C134.6,52 118.9,58.1 107.4,83.7 C106.9,85 99.8,104.5 87,125.3 C85.3,128.1 82.9,131.4 80.5,134.8 L80,135 C71,147.5 58.8,164.7 62.1,177.8 L62.1,178 C63,181.2 63.3,184.3 63.1,187.2 L63.1,187.2 L63.1,187.3 L63.1,187.4 C63.1,187.9 63,188.3 62.9,188.8 L62.9,188.8 L62.9,188.9 L62.9,189.2 C62.9,190.9 64.3,192.3 66,192.3 C66.2,192.2 66.4,192.2 66.6,192.2 L66.6,192.2 Z M204.1,112 L204.1,112 L204.3,111.9 L204.4,111.9 L204.5,111.9 C207.3,110.1 210.4,108.4 213.9,106.7 L213.9,106.7 C214,106.7 214.1,106.6 214.3,106.5 C215.3,106 215.8,104.9 215.8,103.8 L215.8,103.7 L215.8,103.5 C215.7,102.7 215.3,101.9 214.6,101.4 L214.6,101.4 C211.1,98.9 209.1,96.2 208.7,95.6 C205.7,91 204.9,86.5 206.3,82.2 C207.4,78.9 209.8,75.8 213.5,73.1 L213.6,73.1 C213.7,73.1 213.7,73 213.8,73 L213.8,73 C214.5,72.4 214.9,71.6 214.9,70.7 L214.9,70.6 L214.9,70.4 C214.8,69.6 214.5,69 213.9,68.4 L213.1,67.7 L213.2,67.6 C209.7,63.8 207.2,59.7 205.6,55.2 L205.6,55.2 L205.3,54 C204.9,52.7 203.7,51.8 202.4,51.8 C201.4,51.8 200.5,52.3 200,53 C199.9,53.1 199.8,53.3 199.7,53.5 C199.6,53.6 199.6,53.8 199.5,53.9 C199.5,54 199.5,54 199.4,54.1 L199.4,54.2 L199.4,54.3 C196.8,64.5 197.8,75.8 198.7,87.8 L198.7,87.9 C199.3,94.9 199.9,102.2 199.7,109.3 L199.7,109.4 L199.7,109.6 L199.7,109.7 C199.7,111.4 201.1,112.7 202.8,112.7 C203.1,112.4 203.7,112.2 204.1,112 L204.1,112 Z M51.6,246.7 C62.7,246.7 68.4,242 77,235 L77.4,234.7 C78.6,233.7 79.8,232.7 81.1,231.7 L81.2,231.7 C81.7,231.3 82.1,231 82.6,230.6 L82.7,230.5 L82.8,230.5 C88,226.4 95.5,221 106.4,215.6 C113.1,212.1 119.7,209.6 127.2,207.8 C133.7,206.2 139.8,205.4 146.4,204.6 L146.8,204.5 C149.1,204.2 151.5,203.9 153.9,203.5 C161,202.5 167.8,200.9 174,198.7 C199,190 214.9,172.4 218.7,149.1 C221.7,130.6 226.5,122.1 233.8,113.5 C234.4,112.8 235.1,112 236,111 C236.5,110.4 236.8,109.7 236.8,108.9 L236.8,108.8 L236.8,108.6 C236.6,107 235.3,105.8 233.8,105.8 C233.4,105.8 233.1,105.9 232.7,106 L231.3,106.5 L231.3,106.4 C221.4,109.7 201.2,117.7 196.5,128.9 C196.4,129.3 196.2,129.6 196.1,130 C194,135.3 191.1,140 187.2,144.2 C174.8,157.6 162.6,160.8 150.7,163.9 C139.3,166.9 128.6,169.7 118,181.9 L117.9,182 C117.8,182.1 111.4,188.8 100.4,208 C94.2,218.9 83.7,227.4 70.7,231.9 C64.6,234.1 58.1,235.2 51.9,235.2 C46.4,235.2 41.1,234.3 36.8,232.5 L36.8,232.5 L36.7,232.5 L36.5,232.5 L36.3,232.3 C35.1,231.8 33.9,231.5 32.7,231.5 C31.4,231.5 30.2,231.8 29.1,232 C28,232.3 26.7,232.6 25.4,232.6 L25,232.6 L24.9,232.6 L24.6,232.6 L24.4,232.6 C23.5,232.7 22.7,233.1 22.2,233.8 C22.2,233.8 22.1,233.9 22.1,234 L22.1,234.1 L21.9,234.3 C21.7,234.7 21.6,235.2 21.6,235.6 C21.6,236.5 22,237.4 22.7,238 L22.8,238.1 C23.5,238.7 24.3,239.2 25.1,239.7 C32.1,244.2 41,246.4 51.3,246.5 L51.6,246.5 L51.6,246.7 Z M181.1,38.4 C179.4,37.6 177.5,36.8 175.4,36.2 C175.1,36.1 174.8,36 174.4,35.9 C174.2,36.6 173.5,38.1 173.5,38.1 C173.3,38.6 173.1,39.2 173.1,39.8 C173.1,42.1 174.9,43.9 177.2,43.9 C177.5,43.9 177.7,43.9 178,43.8 C178.2,43.8 178.3,43.7 178.5,43.7 C180.8,43.1 183,42.2 185.2,41 C184,40.1 182.7,39.2 181.1,38.4 L181.1,38.4 Z M222.7,323.3 L222.7,323.3 C222.8,323.2 222.9,323.1 223,323.1 L223.2,323 C228.3,319.3 233.4,315.3 238.2,311.2 C258.4,294.1 275.8,274.3 290,252.3 L290,252.2 C290.1,252.1 290.2,251.9 290.3,251.8 C290.5,251.4 290.7,250.9 290.7,250.4 L290.7,250.3 L290.7,250.1 C290.6,249.1 290,248.2 289.1,247.7 L289,247.7 L289,247.7 C286,246.2 283.1,244.2 280.5,241.6 C269.8,231.1 263.1,212.7 260.7,187 L260.5,185.3 C259.7,176.3 258,157.6 249.1,143.6 L249.1,143.6 C245.2,137.9 241.4,131.9 238,125.7 L237.9,125.5 C237.3,124.6 236.4,124.1 235.3,124.1 C234.3,124.1 233.4,124.6 232.9,125.3 L232.9,125.3 C232.9,125.4 232.8,125.4 232.8,125.5 L232.6,125.8 C229,132.1 226.6,139.6 224.8,150.1 C221.9,167.9 212.5,182.9 197.8,193.5 C197.7,193.5 197.7,193.6 197.6,193.6 L197.5,193.7 C197.3,193.9 197.1,194 196.9,194.3 C196.9,194.3 196.8,194.4 196.8,194.5 L196.8,194.6 L196.6,194.8 C196.4,195.2 196.3,195.7 196.3,196.1 C196.3,197.3 197,198.4 198.2,198.9 L198.8,199.2 C202.7,201 206.2,203.6 209.1,207.1 C219.9,219.9 223,243 217.6,270.4 C213.7,290.2 214.9,305.1 216.6,314.1 C217.1,316.7 217.7,319.2 218.4,321.5 C218.4,321.6 218.4,321.6 218.5,321.7 C218.9,323 220.1,323.8 221.4,323.8 C221.7,323.7 222.2,323.6 222.7,323.3 L222.7,323.3 Z M296.6,241.4 L296.7,241.2 L296.8,241 C306.1,224.7 311.3,211.3 313.6,204.7 C313.6,204.6 313.7,204.5 313.7,204.5 C313.8,204.2 313.8,203.9 313.8,203.6 L313.8,203.5 L313.8,203.3 C313.7,202.3 313.1,201.4 312.2,200.9 C297.5,193.9 283.5,183.5 270.6,170.2 C270.6,170.2 270.3,169.9 270.2,169.8 C269.7,169.3 268.9,169.1 268.2,169.1 C267.2,169.1 266.3,169.6 265.8,170.3 C265.8,170.3 265.7,170.4 265.7,170.5 L265.7,170.6 L265.5,170.8 C265.3,171.2 265.2,171.7 265.2,172.1 L265.2,172.4 L265.2,172.5 L265.3,172.8 C266,177.5 266.4,181.7 266.7,184.7 L266.9,186.4 C268.4,202.9 272.7,225 284.5,236.8 C286.9,239.2 289.5,241.1 292.1,242.3 L293,242.7 C293.4,242.9 293.8,242.9 294.2,242.9 C295.1,242.7 296,242.2 296.6,241.4 L296.6,241.4 Z M19.4,217.7 L19.4,217.7 L19.4,217.6 L19.4,217.5 L19.4,217.3 L19.4,217.3 C19.2,215.7 18.1,214.3 16.5,213.8 C16.4,213.8 16.3,213.8 16.2,213.7 C15.1,213.4 13.9,213 12.6,212.4 L12.5,212.4 C11,211.7 9.4,210.8 7.8,209.8 C7.1,209.4 6.3,208.8 5.4,208.1 L5.3,208 C4.8,207.7 4.2,207.4 3.6,207.4 C2.7,207.4 1.8,207.9 1.3,208.6 L1.3,208.6 C1.2,208.7 1.2,208.8 1.1,208.9 L1.1,208.9 C0.9,209.3 0.8,209.8 0.8,210.3 C0.8,210.6 0.8,210.8 0.9,211 C0.9,211.1 0.9,211.1 1,211.2 C1.1,211.5 1.2,211.9 1.3,212.2 C2.8,216.4 5.2,220 8.1,222.4 L8.1,222.4 C10.4,224.3 12.8,225.3 14.8,225.2 C15,225.2 15.2,225.1 15.4,225.1 C16.3,224.9 17.1,224.5 17.7,223.7 C19.2,221.9 19.5,219.7 19.4,217.7 L19.4,217.7 Z M51.8,173.8 L51.8,173.6 C51.7,172.4 50.9,171.4 49.7,171 L49.6,171 C48.1,170.6 46.4,170.4 44.5,170.4 C43.9,170.4 43.2,170.4 42.6,170.5 C38.6,170.8 34.4,172.3 30.1,174.9 C26.1,177.4 22.9,178.5 20.2,178.5 C16.6,178.5 14.2,176.4 11.4,173.7 C10.2,172.5 8.9,171.9 7.4,171.9 C6.4,171.9 5.4,172.2 4.3,172.7 C4.1,172.8 3.5,173.3 3,173.7 C2.8,173.9 2.7,174.1 2.5,174.3 L2.5,174.3 L2.4,174.4 C2.4,174.4 2.3,174.5 2.3,174.6 L2.3,174.7 L2.1,174.9 C1.9,175.3 1.8,175.8 1.8,176.2 C1.8,177.8 3,179.1 4.5,179.2 L4.7,179.2 C6.2,179.3 7.7,180 9.2,181.1 C15.2,185.6 14,189.4 13,193.2 C12.8,193.8 12.7,194.4 12.5,195.1 L12.4,195.4 C12.1,196.7 11.9,197.9 11.8,199.1 C11.7,200.2 11.7,201.2 11.7,202.1 C11.9,205.7 13.5,206.8 14.9,207.6 C15.1,207.7 15.3,207.8 15.5,207.9 C15.7,208 16,208.1 16.3,208.1 C17.1,208.1 17.8,207.6 18.1,206.9 C18.1,206.8 18.2,206.7 18.2,206.6 C18.2,206.5 18.3,206.4 18.4,206.3 L18.4,206.2 C18.4,206.1 18.5,206.1 18.5,206 L18.7,205.8 C18.8,205.7 18.9,205.6 19,205.6 C19.1,205.5 19.2,205.5 19.3,205.4 C19.4,205.4 19.4,205.3 19.5,205.3 C19.6,205.3 19.6,205.2 19.7,205.2 L19.8,205.2 C19.9,205.2 19.9,205.1 20,205.1 L20,205.1 L20.1,205.1 L20.2,205.1 L20.4,205.1 L20.7,205.1 L21,205.1 L21.3,205.1 L21.6,205.1 C21.7,205.1 21.8,205.1 21.9,205.2 L22,205.2 L22.2,205.3 C22.3,205.3 22.4,205.4 22.6,205.5 C22.7,205.5 22.7,205.6 22.8,205.6 C22.9,205.7 23,205.7 23.1,205.8 L23.3,206 L23.5,206.2 C23.6,206.3 23.7,206.4 23.7,206.5 L23.7,206.5 C23.7,206.6 23.8,206.6 23.8,206.7 L23.8,206.8 C23.8,206.9 23.9,206.9 23.9,207 L24,207.1 C24,207.2 24.1,207.2 24.1,207.3 C24.4,208.2 24.9,208.8 25.7,209.3 C26.6,209.8 27.7,210.1 29.1,210.1 C29.9,210.1 30.8,210 31.7,209.8 C32.7,209.5 33.2,209 33.2,208.7 C33.3,208.3 33,207.6 32.5,207 L32.4,206.9 C32.2,206.7 32.1,206.5 31.9,206.2 C31.3,205.3 30.7,204.6 29.9,203.4 L29.6,202.9 C28.5,201.3 27.6,199.7 26.9,198 L26.6,197.3 C24.6,192.3 24.7,187.5 26.9,184.1 C28.6,181.5 31.3,180.1 34.6,180 L34.7,180 C38.7,180 40.2,183.4 40.9,185.7 L40.9,185.7 C41.2,186.8 42.2,187.5 43.4,187.5 C43.9,187.5 44.3,187.4 44.6,187.2 C44.7,187.1 44.8,187.1 44.9,187 C45,186.9 45.1,186.9 45.2,186.8 C47.4,185.3 48,184.9 48.2,181.9 C48.2,180.2 48.9,177.9 50.7,176.4 C50.8,176.3 50.9,176.3 51,176.2 C51.7,175.6 52.1,174.8 52.1,173.9 C51.8,173.9 51.8,173.9 51.8,173.8 L51.8,173.8 Z M192.3,88.1 C192.2,86.3 192,84.5 191.9,82.7 L191.9,82.5 C191.7,80.9 190.4,79.7 188.9,79.7 C187.9,79.7 187,80.2 186.5,80.9 C186.5,80.9 186.4,81 186.4,81.1 L186.4,81.2 L186.2,81.4 C176.3,96.7 165.9,103.9 162.4,106.1 C161.5,110.2 158,121.8 145.1,130.3 C144.8,130.5 144.5,130.7 144.2,130.9 C144,131 143.8,131.1 143.6,131.3 C130.3,139.4 116.3,137.8 116.3,137.8 L116.3,137.8 C103.1,135.9 99.4,144.4 98,149.7 L97.2,152.9 C94.7,163.3 92.2,174 88.2,183.1 C83.2,194.7 74.4,196.8 66.7,198.6 C62.2,199.7 58,200.7 54.6,203.4 C54.3,203.7 54,204 53.6,204.2 C51.1,206.2 48.7,208 46.4,209.5 L45.7,210 C41.2,212.9 37,214.8 33.3,215.6 L32.8,215.7 C32.7,215.7 32.6,215.7 32.5,215.8 L32.3,215.8 C30.9,216.1 30,217.4 30,218.8 C30,219.4 30.2,220 30.5,220.5 L30.5,220.5 C30.6,220.6 30.7,220.7 30.8,220.9 C30.8,220.9 30.8,221 30.9,221 C32.8,223.4 35.4,225.3 38.7,226.7 L38.9,226.8 C42.6,228.3 47,229.1 51.7,229.1 C65.8,229.1 85.3,221.6 94.8,205 C105.9,185.7 112.5,178.5 113.2,177.8 C125,164.2 137.2,161 149,157.9 C160.5,154.9 171.3,152.1 182.5,140 C185.9,136.4 188.4,132.4 190.1,127.8 C190.2,127.4 190.4,127 190.5,126.7 C194.5,115 193.4,101.3 192.3,88.1 L192.3,88.1 Z M27.1,134.3 C27.1,134.2 27.1,134 27,133.9 L27,133.8 C26.3,132.4 25.5,130.5 24.9,128.1 L24.9,127.9 C24.6,127.1 23.8,126.4 22.9,126.4 C22.2,126.4 21.6,126.7 21.2,127.2 L21.2,127.2 C21.2,127.3 21.1,127.4 21.1,127.4 L21.1,127.4 C21.1,127.4 21.1,127.5 21,127.5 C20.9,127.6 20.9,127.8 20.9,127.9 C19.9,130.9 18.9,133.6 17.8,136 C17.1,137.5 16.4,138.8 15.7,140.1 L15.7,140.1 L15.7,140.1 C15.7,140.1 15.7,140.2 15.6,140.2 L15.6,140.2 C15.6,140.2 15.6,140.2 15.6,140.3 L15.6,140.3 C15.6,140.4 15.5,140.5 15.5,140.7 C15.5,140.9 15.5,141 15.6,141.2 C15.6,141.2 15.6,141.3 15.7,141.3 C15.9,141.5 16,141.7 16.2,142 L16.2,142 C16.9,143.2 18.1,144.4 19.5,144.4 C21,144.4 22.5,143.1 23.2,141.8 C23.2,141.7 23.3,141.7 23.3,141.6 C24.4,139.5 25.7,137.2 27,135 C27,134.9 27.1,134.8 27.1,134.8 L27.1,134.8 C27.2,134.6 27.2,134.5 27.2,134.3 C27.1,134.4 27.1,134.4 27.1,134.3 L27.1,134.3 L27.1,134.3 Z M14.2,147.3 C14.2,147.2 14.1,147.2 14.1,147.1 C14.1,147.1 14.1,147 14,147 C13.7,146.6 13.2,146.3 12.7,146.3 C12.2,146.3 11.7,146.5 11.4,146.9 L11.4,146.9 C11.4,146.9 11.4,147 11.3,147 C11.3,147 11.3,147 11.3,147.1 L11.3,147.1 C11.3,147.1 11.3,147.2 11.2,147.2 L11.2,147.2 C8.7,152.2 8.2,156.4 8,159.7 L8,159.9 L8,159.9 C8,160.8 8.7,161.5 9.6,161.5 C9.9,161.5 10.2,161.4 10.5,161.2 L10.6,161.1 C11,160.8 11.4,160.5 11.7,160.2 L11.8,160.1 C12.3,159.7 13.4,158.8 14.6,157.5 C14.6,157.5 14.6,157.5 14.7,157.4 L14.7,157.4 L14.8,157.3 L14.8,157.3 C17.4,154.9 16.3,151.2 14.2,147.3 L14.2,147.3 Z" id="Shape" sketch:type="MSShapeGroup"></path>
                      </g>
                  </g>
              </svg>
              
            </div>
          </div>
          <div class="col-md-10">
            <h1>3rd-Party Software for <a href="https://github.com/viewv/FeJ">FeJ</a></h1>
            <p>The following 3rd-party software packages may be used by or distributed with <b>FeJ</b>.  This document was automatically generated by <a href="https://fossa.com">FOSSA</a> on 12/12/19; any information relevant to third-party vendors listed below are collected using common, reasonable means.</p>
            <small><b>Revision ID:</b> 04dbd2d6075a2aef709cbd23fd00ee337c949040</small>
          </div>
        </div>
      </header>

      

      

      
      
        
          <div class="card">
            <h2>Direct Dependencies</h2>
            
            <table style="table-layout:fixed;" class="table table-bordered">
  <thead>
    <tr>
    
      <th>Package</th>
    
    
    
    
      <th>License</th>
    
    
      <th>Other Licenses</th>
    
    
    
    
    
    
    </tr>
  </thead>
  <tbody>
  
    <tr>
      
        <td>
        
          SQLite JDBC
        
        </td>
      
      
      
      
        <td style="width: 50%">
          <ul>
          
            <li>
            
            
              
              
                <a href="#Apache-2.0">Apache-2.0</a>
              
              
            

            
              
                <p style="padding-left: 20px;">Attribution Notice:</p>
                <pre style="max-height: 200px;">Copyright 2009 Taro L
Licensed under the Apache License, Version 2.0 (the &quot;License&quot;); you may not use this file except in compliance with the License. You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an &quot;AS IS&quot; BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.</pre>
              
            
            
            </li>
          
          </ul>
        </td>
      
      
        <td style="width: 50%">
          <ul>
          
            <li>
            
            
              
              
                <a href="#MIT">MIT</a>
              
              
            

            
              
              <p style="padding-left: 20px;">Attribution:</p>
              <pre style="max-height: 200px;">Copyright (c) 2007 David Crawshaw 
Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the &quot;Software&quot;), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
THE SOFTWARE IS PROVIDED &quot;AS IS&quot;, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.</pre>
              

            
            
            </li>
          
            <li>
            
            
              
              
                <a href="#Artistic-2.0">Artistic-2.0</a>
              
              
            

            
              

            
            
            </li>
          
          </ul>
        </td>
      
      
      
      
      
      
    </tr>
  
    <tr>
      
        <td>
        
          <a href="jgravatar is a tiny Java library for accessing avatar images from gravatar.com">jgravatar (1.1)</a> <br>
          <small><i>(jgravatar is a tiny Java library for accessing avatar images from gravatar.com)</i></small>
        
        </td>
      
      
      
      
        <td style="width: 50%">
          <ul>
          
            <li>
            <b>Multi-license: </b>
            
              
              
                <a href="#LGPL-3.0-only">LGPL-3.0-only</a>
              
              
            
               OR 
              
                <a href="#MIT">MIT</a>
              
              
            

            
              
                
              
            
            
            </li>
          
          </ul>
        </td>
      
      
        <td style="width: 50%">
          <ul>
          
            <li>
            
            
              
              
                <a href="#public-domain">public-domain</a>
              
              
            

            
              

            
            
            </li>
          
          </ul>
        </td>
      
      
      
      
      
      
    </tr>
  
    <tr>
      
        <td>
        
          mysql-connector-java
        
        </td>
      
      
      
      
        <td style="width: 50%">
          <ul>
          
            <li>
            
            
              
              
                <a href="#GPL-2.0-only">GPL-2.0-only</a>
              
              
            

            
              
                <p style="padding-left: 20px;">Attribution Notice:</p>
                <pre style="max-height: 200px;">Copyright (C) 2015, 2018, Oracle and
This program is free software; you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation; version 2.
This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
You should have received a copy of the GNU General Public License along with this program; if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.</pre>
              
            
            
            </li>
          
          </ul>
        </td>
      
      
        <td style="width: 50%">
          <ul>
          
            <li>
            <b>Multi-license: </b>
            
              
              
                <a href="#GPL-2.0-only">GPL-2.0-only</a>
              
              
            
               OR 
              
                <a href="#Apache-2.0">Apache-2.0</a>
              
              
            

            
              
              <p style="padding-left: 20px;">Attribution:</p>
              <pre style="max-height: 200px;">Copyright (C) 2015, 2018, Oracle and
This program is free software; you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation; version 2.
This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
You should have received a copy of the GNU General Public License along with this program; if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.</pre>
              

            
            
            </li>
          
            <li>
            
            
              
              
                <a href="#GPL-3.0-only">GPL-3.0-only</a>
              
              
            

            
              
              <p style="padding-left: 20px;">Custom Text:</p>
              <pre style="max-height: 200px;">Licensing Information User Manual

MySQL Connector/J 8.0
     __________________________________________________________________

Introduction

   This License Information User Manual contains Oracle&#39;s product license
   and other licensing information, including licensing information for
   third-party software which may be included in this distribution of
   MySQL Connector/J 8.0.

   Last updated: June 2019

Licensing Information

   This is a release of MySQL Connector/J 8.0, brought to you by the MySQL
   team at Oracle. This software is released under version 2 of the GNU
   General Public License (GPLv2), as set forth below, with the following
   additional permissions:

   This distribution of MySQL Connector/J 8.0 is distributed with certain
   software that is licensed under separate terms, as designated in a
   particular file or component or in the license documentation. Without
   limiting your rights under the GPLv2, the authors of MySQL hereby grant
   you an additional permission to link the program and your derivative
   works with the separately licensed software that they have included
   with the program.

   Without limiting the foregoing grant of rights under the GPLv2 and
   additional permission as to separately licensed software, this
   Connector is also subject to the Universal FOSS Exception, version 1.0,
   a copy of which is reproduced below and can also be found along with
   its FAQ at http://oss.oracle.com/licenses/universal-foss-exception.

   Copyright (c) 2017, 2019, Oracle and/or its affiliates. All rights
   reserved.

Election of GPLv2

   For the avoidance of doubt, except that if any license choice other
   than GPL or LGPL is available it will apply instead, Oracle elects to
   use only the General Public License version 2 (GPLv2) at this time for
   any software where a choice of GPL license versions is made available
   with the language indicating that GPLv2 or any later version may be
   used, or where a choice of which version of the GPL is applied is
   otherwise unspecified.

GNU General Public License Version 2.0, June 1991

The following applies to all products licensed under the GNU General
Public License, Version 2.0: You may not use the identified files
except in compliance with the GNU General Public License, Version
2.0 (the &quot;License.&quot;) You may obtain a copy of the License at
http://www.gnu.org/licenses/gpl-2.0.txt. A copy of the license is
also reproduced below. Unless required by applicable law or agreed
to in writing, software distributed under the License is distributed
on an &quot;AS IS&quot; BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
either express or implied. See the License for the specific language
governing permissions and limitations under the License.

GNU GENERAL PUBLIC LICENSE
Version 2, June 1991

Copyright (C) 1989, 1991 Free Software Foundation, Inc.,
51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA
Everyone is permitted to copy and distribute verbatim
copies of this license document, but changing it is not
allowed.

                     Preamble

  The licenses for most software are designed to take away your
freedom to share and change it.  By contrast, the GNU General Public
License is intended to guarantee your freedom to share and change free
software--to make sure the software is free for all its users.  This
General Public License applies to most of the Free Software
Foundation&#39;s software and to any other program whose authors commit to
using it.  (Some other Free Software Foundation software is covered by
the GNU Lesser General Public License instead.)  You can apply it to
your programs, too.

  When we speak of free software, we are referring to freedom, not
price.  Our General Public Licenses are designed to make sure that you
have the freedom to distribute copies of free software (and charge for
this service if you wish), that you receive source code or can get it
if you want it, that you can change the software or use pieces of it
in new free programs; and that you know you can do these things.

  To protect your rights, we need to make restrictions that forbid
anyone to deny you these rights or to ask you to surrender the rights.
These restrictions translate to certain responsibilities for you if you
distribute copies of the software, or if you modify it.

  For example, if you distribute copies of such a program, whether
gratis or for a fee, you must give the recipients all the rights that
you have.  You must make sure that they, too, receive or can get the
source code.  And you must show them these terms so they know their
rights.

  We protect your rights with two steps: (1) copyright the software,
and (2) offer you this license which gives you legal permission to
copy, distribute and/or modify the software.

  Also, for each author&#39;s protection and ours, we want to make certain
that everyone understands that there is no warranty for this free
software.  If the software is modified by someone else and passed on,
we want its recipients to know that what they have is not the original,
so that any problems introduced by others will not reflect on the
original authors&#39; reputations.

  Finally, any free program is threatened constantly by software
patents.  We wish to avoid the danger that redistributors of a free
program will individually obtain patent licenses, in effect making the
program proprietary.  To prevent this, we have made it clear that any
patent must be licensed for everyone&#39;s free use or not licensed at all.

  The precise terms and conditions for copying, distribution and
modification follow.

                    GNU GENERAL PUBLIC LICENSE
   TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION

  0. This License applies to any program or other work which contains
a notice placed by the copyright holder saying it may be distributed
under the terms of this General Public License.  The &quot;Program&quot;, below,
refers to any such program or work, and a &quot;work based on the Program&quot;
means either the Program or any derivative work under copyright law:
that is to say, a work containing the Program or a portion of it,
either verbatim or with modifications and/or translated into another
language.  (Hereinafter, translation is included without limitation in
the term &quot;modification&quot;.)  Each licensee is addressed as &quot;you&quot;.

Activities other than copying, distribution and modification are not
covered by this License; they are outside its scope.  The act of
running the Program is not restricted, and the output from the Program
is covered only if its contents constitute a work based on the
Program (independent of having been made by running the Program).
Whether that is true depends on what the Program does.


  1. You may copy and distribute verbatim copies of the Program&#39;s
source code as you receive it, in any medium, provided that you
conspicuously and appropriately publish on each copy an appropriate
copyright notice and disclaimer of warranty; keep intact all the
notices that refer to this License and to the absence of any warranty;
and give any other recipients of the Program a copy of this License
along with the Program.

You may charge a fee for the physical act of transferring a copy, and
you may at your option offer warranty protection in exchange for a fee.


  2. You may modify your copy or copies of the Program or any portion
of it, thus forming a work based on the Program, and copy and
distribute such modifications or work under the terms of Section 1
above, provided that you also meet all of these conditions:

    a) You must cause the modified files to carry prominent notices
    stating that you changed the files and the date of any change.

    b) You must cause any work that you distribute or publish, that in
    whole or in part contains or is derived from the Program or any
    part thereof, to be licensed as a whole at no charge to all third
    parties under the terms of this License.

    c) If the modified program normally reads commands interactively
    when run, you must cause it, when started running for such
    interactive use in the most ordinary way, to print or display an
    announcement including an appropriate copyright notice and a
    notice that there is no warranty (or else, saying that you provide
    a warranty) and that users may redistribute the program under
    these conditions, and telling the user how to view a copy of this
    License.  (Exception: if the Program itself is interactive but
    does not normally print such an announcement, your work based on
    the Program is not required to print an announcement.)

These requirements apply to the modified work as a whole.  If
identifiable sections of that work are not derived from the Program,
and can be reasonably considered independent and separate works in
themselves, then this License, and its terms, do not apply to those
sections when you distribute them as separate works.  But when you
distribute the same sections as part of a whole which is a work based
on the Program, the distribution of the whole must be on the terms of
this License, whose permissions for other licensees extend to the
entire whole, and thus to each and every part regardless of who wrote it.

Thus, it is not the intent of this section to claim rights or contest
your rights to work written entirely by you; rather, the intent is to
exercise the right to control the distribution of derivative or
collective works based on the Program.

In addition, mere aggregation of another work not based on the Program
with the Program (or with a work based on the Program) on a volume of
a storage or distribution medium does not bring the other work under
the scope of this License.


  3. You may copy and distribute the Program (or a work based on it,
under Section 2) in object code or executable form under the terms of
Sections 1 and 2 above provided that you also do one of the following:

    a) Accompany it with the complete corresponding machine-readable
    source code, which must be distributed under the terms of Sections
    1 and 2 above on a medium customarily used for software
    interchange; or,

    b) Accompany it with a written offer, valid for at least three
    years, to give any third party, for a charge no more than your
    cost of physically performing source distribution, a complete
    machine-readable copy of the corresponding source code, to be
    distributed under the terms of Sections 1 and 2 above on a medium
    customarily used for software interchange; or,

    c) Accompany it with the information you received as to the offer
    to distribute corresponding source code.  (This alternative is
    allowed only for noncommercial distribution and only if you
    received the program in object code or executable form with such
    an offer, in accord with Subsection b above.)

The source code for a work means the preferred form of the work for
making modifications to it.  For an executable work, complete source
code means all the source code for all modules it contains, plus any
associated interface definition files, plus the scripts used to
control compilation and installation of the executable.  However, as
a special exception, the source code distributed need not include
anything that is normally distributed (in either source or binary
form) with the major components (compiler, kernel, and so on) of the
operating system on which the executable runs, unless that component
itself accompanies the executable.

If distribution of executable or object code is made by offering
access to copy from a designated place, then offering equivalent
access to copy the source code from the same place counts as
distribution of the source code, even though third parties are not
compelled to copy the source along with the object code.


  4. You may not copy, modify, sublicense, or distribute the Program
except as expressly provided under this License.  Any attempt
otherwise to copy, modify, sublicense or distribute the Program is
void, and will automatically terminate your rights under this License.
However, parties who have received copies, or rights, from you under
this License will not have their licenses terminated so long as such
parties remain in full compliance.


  5. You are not required to accept this License, since you have not
signed it.  However, nothing else grants you permission to modify or
distribute the Program or its derivative works.  These actions are
prohibited by law if you do not accept this License.  Therefore, by
modifying or distributing the Program (or any work based on the
Program), you indicate your acceptance of this License to do so, and
all its terms and conditions for copying, distributing or modifying
the Program or works based on it.


  6. Each time you redistribute the Program (or any work based on the
Program), the recipient automatically receives a license from the
original licensor to copy, distribute or modify the Program subject to
these terms and conditions.  You may not impose any further
restrictions on the recipients&#39; exercise of the rights granted herein.
You are not responsible for enforcing compliance by third parties to
this License.


  7. If, as a consequence of a court judgment or allegation of patent
infringement or for any other reason (not limited to patent issues),
conditions are imposed on you (whether by court order, agreement or
otherwise) that contradict the conditions of this License, they do not
excuse you from the conditions of this License.  If you cannot
distribute so as to satisfy simultaneously your obligations under this
License and any other pertinent obligations, then as a consequence you
may not distribute the Program at all.  For example, if a patent
license would not permit royalty-free redistribution of the Program by
all those who receive copies directly or indirectly through you, then
the only way you could satisfy both it and this License would be to
refrain entirely from distribution of the Program.

If any portion of this section is held invalid or unenforceable under
any particular circumstance, the balance of the section is intended to
apply and the section as a whole is intended to apply in other
circumstances.

It is not the purpose of this section to induce you to infringe any
patents or other property right claims or to contest validity of any
such claims; this section has the sole purpose of protecting the
integrity of the free software distribution system, which is
implemented by public license practices.  Many people have made
generous contributions to the wide range of software distributed
through that system in reliance on consistent application of that
system; it is up to the author/donor to decide if he or she is willing
to distribute software through any other system and a licensee cannot
impose that choice.

This section is intended to make thoroughly clear what is believed to
be a consequence of the rest of this License.


  8. If the distribution and/or use of the Program is restricted in
certain countries either by patents or by copyrighted interfaces, the
original copyright holder who places the Program under this License
may add an explicit geographical distribution limitation excluding
those countries, so that distribution is permitted only in or among
countries not thus excluded.  In such case, this License incorporates
the limitation as if written in the body of this License.


  9. The Free Software Foundation may publish revised and/or new
versions of the General Public License from time to time.  Such new
versions will be similar in spirit to the present version, but may
differ in detail to address new problems or concerns.

Each version is given a distinguishing version number.  If the Program
specifies a version number of this License which applies to it and
&quot;any later version&quot;, you have the option of following the terms and
conditions either of that version or of any later version published by
the Free Software Foundation.  If the Program does not specify a
version number of this License, you may choose any version ever
published by the Free Software Foundation.

  10. If you wish to incorporate parts of the Program into other free
programs whose distribution conditions are different, write to the
author to ask for permission.  For software which is copyrighted by the
Free Software Foundation, write to the Free Software Foundation; we
sometimes make exceptions for this.  Our decision will be guided by the
two goals of preserving the free status of all derivatives of our free
software and of promoting the sharing and reuse of software generally.

                            NO WARRANTY

  11. BECAUSE THE PROGRAM IS LICENSED FREE OF CHARGE, THERE IS NO
WARRANTY FOR THE PROGRAM, TO THE EXTENT PERMITTED BY APPLICABLE LAW.
EXCEPT WHEN OTHERWISE STATED IN WRITING THE COPYRIGHT HOLDERS AND/OR
OTHER PARTIES PROVIDE THE PROGRAM &quot;AS IS&quot; WITHOUT WARRANTY OF ANY KIND,
EITHER EXPRESSED OR IMPLIED, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE.
THE ENTIRE RISK AS TO THE QUALITY AND PERFORMANCE OF THE PROGRAM IS
WITH YOU.  SHOULD THE PROGRAM PROVE DEFECTIVE, YOU ASSUME THE COST OF
ALL NECESSARY SERVICING, REPAIR OR CORRECTION.

  12. IN NO EVENT UNLESS REQUIRED BY APPLICABLE LAW OR AGREED TO IN
WRITING WILL ANY COPYRIGHT HOLDER, OR ANY OTHER PARTY WHO MAY MODIFY
AND/OR REDISTRIBUTE THE PROGRAM AS PERMITTED ABOVE, BE LIABLE TO YOU
FOR DAMAGES, INCLUDING ANY GENERAL, SPECIAL, INCIDENTAL OR
CONSEQUENTIAL DAMAGES ARISING OUT OF THE USE OR INABILITY TO USE THE
PROGRAM (INCLUDING BUT NOT LIMITED TO LOSS OF DATA OR DATA BEING
RENDERED INACCURATE OR LOSSES SUSTAINED BY YOU OR THIRD PARTIES OR A
FAILURE OF THE PROGRAM TO OPERATE WITH ANY OTHER PROGRAMS), EVEN IF
SUCH HOLDER OR OTHER PARTY HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH
DAMAGES.

                     END OF TERMS AND CONDITIONS

            How to Apply These Terms to Your New Programs

  If you develop a new program, and you want it to be of the greatest
possible use to the public, the best way to achieve this is to make it
free software which everyone can redistribute and change under these terms.

  To do so, attach the following notices to the program.  It is safest
to attach them to the start of each source file to most effectively
convey the exclusion of warranty; and each file should have at least
the &quot;copyright&quot; line and a pointer to where the full notice is found.

    &lt;one line to give the program&#39;s name and a brief idea of what it does.&gt;
    Copyright (C) &lt;year&gt;  &lt;name of author&gt;

    This program is free software; you can redistribute it and/or
    modify it under the terms of the GNU General Public License as
    published by the Free Software Foundation; either version 2 of

    the License, or (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program; if not, write to the Free Software
    Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
    02110-1301 USA.

Also add information on how to contact you by electronic and paper mail.

If the program is interactive, make it output a short notice like this
when it starts in an interactive mode:

    Gnomovision version 69, Copyright (C) year name of author
    Gnomovision comes with ABSOLUTELY NO WARRANTY; for details
    type &#39;show w&#39;. This is free software, and you are welcome
    to redistribute it under certain conditions; type &#39;show c&#39;
    for details.

The hypothetical commands &#39;show w&#39; and &#39;show c&#39; should show the
appropriate parts of the General Public License.  Of course, the
commands you use may be called something other than &#39;show w&#39; and
&#39;show c&#39;; they could even be mouse-clicks or menu items--whatever
suits your program.

You should also get your employer (if you work as a programmer) or your
school, if any, to sign a &quot;copyright disclaimer&quot; for the program, if
necessary.  Here is a sample; alter the names:

  Yoyodyne, Inc., hereby disclaims all copyright interest in the
  program &#39;Gnomovision&#39; (which makes passes at compilers) written
  by James Hacker.

  &lt;signature of Ty Coon&gt;, 1 April 1989
  Ty Coon, President of Vice

This General Public License does not permit incorporating your program
into proprietary programs.  If your program is a subroutine library,
you may consider it more useful to permit linking proprietary
applications with the library.  If this is what you want to do, use
the GNU Lesser General Public License instead of this License.

The Universal FOSS Exception, Version 1.0

   In addition to the rights set forth in the other license(s) included in
   the distribution for this software, data, and/or documentation
   (collectively the &quot;Software&quot;, and such licenses collectively with this
   additional permission the &quot;Software License&quot;), the copyright holders
   wish to facilitate interoperability with other software, data, and/or
   documentation distributed with complete corresponding source under a
   license that is OSI-approved and/or categorized by the FSF as free
   (collectively &quot;Other FOSS&quot;). We therefore hereby grant the following
   additional permission with respect to the use and distribution of the
   Software with Other FOSS, and the constants, function signatures, data
   structures and other invocation methods used to run or interact with
   each of them (as to each, such software&#39;s &quot;Interfaces&quot;):
    i. The Software&#39;s Interfaces may, to the extent permitted by the
       license of the Other FOSS, be copied into, used and distributed in
       the Other FOSS in order to enable interoperability, without
       requiring a change to the license of the Other FOSS other than as
       to any Interfaces of the Software embedded therein. The Software&#39;s
       Interfaces remain at all times under the Software License,
       including without limitation as used in the Other FOSS (which upon
       any such use also then contains a portion of the Software under the
       Software License).
   ii. The Other FOSS&#39;s Interfaces may, to the extent permitted by the
       license of the Other FOSS, be copied into, used and distributed in
       the Software in order to enable interoperability, without requiring
       that such Interfaces be licensed under the terms of the Software
       License or otherwise altering their original terms, if this does
       not require any portion of the Software other than such Interfaces
       to be licensed under the terms other than the Software License.
   iii. If only Interfaces and no other code is copied between the
       Software and the Other FOSS in either direction, the use and/or
       distribution of the Software with the Other FOSS shall not be
       deemed to require that the Other FOSS be licensed under the license
       of the Software, other than as to any Interfaces of the Software
       copied into the Other FOSS. This includes, by way of example and
       without limitation, statically or dynamically linking the Software
       together with Other FOSS after enabling interoperability using the
       Interfaces of one or both, and distributing the resulting
       combination under different licenses for the respective portions
       thereof. For avoidance of doubt, a license which is OSI-approved or
       categorized by the FSF as free, includes, for the purpose of this
       permission, such licenses with additional permissions, and any
       license that has previously been so approved or categorized as
       free, even if now deprecated or otherwise no longer recognized as
       approved or free. Nothing in this additional permission grants any
       right to distribute any portion of the Software on terms other than
       those of the Software License or grants any additional permission
       of any kind for use or distribution of the Software in conjunction
       with software other than Other FOSS.

Licenses for Third-Party Components

   The following sections contain licensing information for libraries that
   we have included with the MySQL Connector/J 8.0 source and components
   used to test MySQL Connector/J 8.0. Commonly used licenses referenced
   herein can be found in Commonly Used Licenses. We are thankful to all
   individuals that have created these.

Ant-Contrib

   The following software may be included in this product:
Ant-Contrib
Copyright (c) 2001-2003 Ant-Contrib project. All rights reserved.
Licensed under the Apache 1.1 License Agreement, a copy of which is reproduced b
elow.

The Apache Software License, Version 1.1

Copyright (c) 2001-2003 Ant-Contrib project.  All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:


 1. Redistributions of source code must retain the above copyright
    notice, this list of conditions and the following disclaimer.


 2. Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions and the following disclaimer in
    the documentation and/or other materials provided with the
    distribution.


 3. The end-user documentation included with the redistribution, if
    any, must include the following acknowlegement:
       &quot;This product includes software developed by the
        Ant-Contrib project (http://sourceforge.net/projects/ant-contrib).&quot;
    Alternately, this acknowlegement may appear in the software itself,
    if and wherever such third-party acknowlegements normally appear.


 4. The name Ant-Contrib must not be used to endorse or promote
    products derived from this software without prior written
    permission. For written permission, please contact
    ant-contrib-developers@lists.sourceforge.net.


 5. Products derived from this software may not be called &quot;Ant-Contrib&quot;
    nor may &quot;Ant-Contrib&quot; appear in their names without prior written
    permission of the Ant-Contrib project.

 THIS SOFTWARE IS PROVIDED ``AS IS&#39;&#39; AND ANY EXPRESSED OR IMPLIED
 WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 DISCLAIMED.  IN NO EVENT SHALL THE ANT-CONTRIB PROJECT OR ITS
 CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 SUCH DAMAGE.

c3p0 JDBC Library

   This product may include a copy of c3p0-0.9.1-pre6.jar in both source
   and object code in the following /src/lib/c3p0-0.9.1-pre6.jar. The
   terms of the Oracle license do NOT apply to c3p0-0.9.1-pre6.jar; it is
   licensed under the following license, separately from the Oracle
   programs you receive. If you do not wish to install this library, you
   may remove the file /src/lib/c3p0-0.9.1-pre6.jar, but the Oracle
   program might not operate properly or at all without the library.

   This component is licensed under GNU Lesser General Public License
   Version 2.1, February 1999.

Google Protocol Buffers

   The following software may be included in this product:
Copyright 2008 Google Inc.  All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are
met:


    * Redistributions of source code must retain the above copyright
notice, this list of conditions and the following disclaimer.

    * Redistributions in binary form must reproduce the above
copyright notice, this list of conditions and the following disclaimer
in the documentation and/or other materials provided with the
distribution.

    * Neither the name of Google Inc. nor the names of its
contributors may be used to endorse or promote products derived from
this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
&quot;AS IS&quot; AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

Code generated by the Protocol Buffer compiler is owned by the owner
of the input file used when generating it.  This code is not
standalone and requires a support library to be linked with it.  This
support library is itself covered by the above license.

jboss-common-jdbc-wrapper.jar

   This product may include a copy of jboss-common-jdbc-wrapper.jar in
   both source and object code in the following
   /src/lib/jboss-common-jdbc-wrapper.jar. The terms of the Oracle license
   do NOT apply to jboss-common-jdbc-wrapper.jar; it is licensed under the
   following license, separately from the Oracle programs you receive. If
   you do not wish to install this library, you may remove the file
   /src/lib/jboss-common-jdbc-wrapper.jar, but the Oracle program might
   not operate properly or at all without the library.

   This component is licensed under GNU Lesser General Public License
   Version 2.1, February 1999.

NanoXML

   The following software may be included in this product:

   NanoXML

 * Copyright (C) 2000-2002 Marc De Scheemaecker, All Rights Reserved.
 *

 * This software is provided &#39;as-is&#39;, without any express or implied warranty.

 * In no event will the authors be held liable for any damages arising from the

 * use of this software.
 *

 * Permission is granted to anyone to use this software for any purpose,

 * including commercial applications, and to alter it and redistribute it

 * freely, subject to the following restrictions:
 *

 *  1. The origin of this software must not be misrepresented; you must not

 *     claim that you wrote the original software. If you use this software in

 *     a product, an acknowledgment in the product documentation would be

 *     appreciated but is not required.
 *

 *  2. Altered source versions must be plainly marked as such, and must not be

 *     misrepresented as being the original software.
 *

 *  3. This notice may not be removed or altered from any source distribution.
 *

rox.jar

   The following software may be included in this product:

   rox.jar
Copyright (c) 2006, James Greenfield
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:


    * Redistributions of source code must retain the above copyright notice, thi
s
      list of conditions and the following disclaimer.

    * Redistributions in binary form must reproduce the above copyright notice,
      this list of conditions and the following disclaimer in the documentation
      and/or other materials provided with the distribution.

    * Neither the name of the &lt;ORGANIZATION&gt; nor the names of its contributors
      may be used to endorse or promote products derived from this software
      without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS &quot;AS IS&quot;
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIE
D
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVI
CES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

Simple Logging Facade for Java (SLF4J)

   The following software may be included in this product:
Simple Logging Facade for Java (SLF4J)

Copyright (c) 2004-2011 QOS.ch
All rights reserved.

Permission is hereby granted, free of charge,
to any person obtaining a copy of this software
and associated documentation files (the &quot;Software&quot;),
to deal in the Software without restriction, including
without limitation the rights to use, copy, modify,
merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom
the Software is furnished to do so, subject to the
following conditions:

The above copyright notice and this permission notice
shall be included in all copies or substantial portions
of the Software.

THE SOFTWARE IS PROVIDED &quot;AS IS&quot;, WITHOUT WARRANTY
OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT
LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO
EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN
AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE
OR OTHER DEALINGS IN THE SOFTWARE.

Unicode Data Files

   The following software may be included in this product:

   Unicode Data Files
COPYRIGHT AND PERMISSION NOTICE

Copyright (c) 1991-2014 Unicode, Inc. All rights reserved. Distributed under
the Terms of Use in http://www.unicode.org/copyright.html.

Permission is hereby granted, free of charge, to any person obtaining a copy
of the Unicode data files and any associated documentation (the &quot;Data Files&quot;)
or Unicode software and any associated documentation (the &quot;Software&quot;) to deal
in the Data Files or Software without restriction, including without
limitation the rights to use, copy, modify, merge, publish, distribute,
and/or sell copies of the Data Files or Software, and to permit persons to
whom the Data Files or Software are furnished to do so, provided that (a) the
above copyright notice(s) and this permission notice appear with all copies
of the Data Files or Software, (b) both the above copyright notice(s) and
this permission notice appear in associated documentation, and (c) there is
clear notice in each modified Data File or in the Software as well as in the
documentation associated with the Data File(s) or Software that the data or
software has been modified.

THE DATA FILES AND SOFTWARE ARE PROVIDED &quot;AS IS&quot;, WITHOUT WARRANTY OF ANY
KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT OF
THIRD PARTY RIGHTS. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR HOLDERS
INCLUDED IN THIS NOTICE BE LIABLE FOR ANY CLAIM, OR ANY SPECIAL INDIRECT OR
CONSEQUENTIAL DAMAGES, OR ANY DAMAGES WHATSOEVER RESULTING FROM LOSS OF USE,
DATA OR
PROFITS, WHETHER IN AN ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS
ACTION, ARISING OUT OF OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THE
DATA FILES OR SOFTWARE.

Except as contained in this notice, the name of a copyright holder shall not
be used in advertising or otherwise to promote the sale, use or other
dealings in these Data Files or Software without prior written authorization
of the copyright holder.

Commonly Used Licenses

Artistic License (Perl) 1.0

The &quot;Artistic License&quot;

Preamble

The intent of this document is to state the conditions under which a
Package may be copied, such that the Copyright Holder maintains some
semblance of artistic control over the development of the package,
while giving the users of the package the right to use and distribute
the Package in a more-or-less customary fashion, plus the right to make
reasonable modifications.

Definitions:

        &quot;Package&quot; refers to the collection of files distributed by the
        Copyright Holder, and derivatives of that collection of files
        created through textual modification.

        &quot;Standard Version&quot; refers to such a Package if it has not been
        modified, or has been modified in accordance with the wishes
        of the Copyright Holder as specified below.

        &quot;Copyright Holder&quot; is whoever is named in the copyright or
        copyrights for the package.

        &quot;You&quot; is you, if you&#39;re thinking about copying or distributing
        this Package.

        &quot;Reasonable copying fee&quot; is whatever you can justify on the
        basis of media cost, duplication charges, time of people involved,
        and so on.  (You will not be required to justify it to the
        Copyright Holder, but only to the computing community at large
        as a market that must bear the fee.)

        &quot;Freely Available&quot; means that no fee is charged for the item
        itself, though there may be fees involved in handling the item.
        It also means that recipients of the item may redistribute it
        under the same conditions they received it.

1. You may make and give away verbatim copies of the source form of the
Standard Version of this Package without restriction, provided that you
duplicate all of the original copyright notices and associated disclaimers.

2. You may apply bug fixes, portability fixes and other modifications
derived from the Public Domain or from the Copyright Holder.  A Package
modified in such a way shall still be considered the Standard Version.

3. You may otherwise modify your copy of this Package in any way, provided
that you insert a prominent notice in each changed file stating how and
when you changed that file, and provided that you do at least ONE of the
following:

    a) place your modifications in the Public Domain or otherwise make them
    Freely Available, such as by posting said modifications to Usenet or
    an equivalent medium, or placing the modifications on a major archive
    site such as uunet.uu.net, or by allowing the Copyright Holder to include
    your modifications in the Standard Version of the Package.

    b) use the modified Package only within your corporation or organization.

    c) rename any non-standard executables so the names do not conflict
    with standard executables, which must also be provided, and provide
    a separate manual page for each non-standard executable that clearly
    documents how it differs from the Standard Version.

    d) make other distribution arrangements with the Copyright Holder.

4. You may distribute the programs of this Package in object code or
executable form, provided that you do at least ONE of the following:

    a) distribute a Standard Version of the executables and library files,
    together with instructions (in the manual page or equivalent) on where
    to get the Standard Version.

    b) accompany the distribution with the machine-readable source of
    the Package with your modifications.

    c) give non-standard executables non-standard names, and clearly
    document the differences in manual pages (or equivalent), together
    with instructions on where to get the Standard Version.

    d) make other distribution arrangements with the Copyright Holder.

5. You may charge a reasonable copying fee for any distribution of this
Package.  You may charge any fee you choose for support of this
Package.  You may not charge a fee for this Package itself.  However,
you may distribute this Package in aggregate with other (possibly
commercial) programs as part of a larger (possibly commercial) software
distribution provided that you do not advertise this Package as a
product of your own.  You may embed this Package&#39;s interpreter within
an executable of yours (by linking); this shall be construed as a mere
form of aggregation, provided that the complete Standard Version of the
interpreter is so embedded.

6. The scripts and library files supplied as input to or produced as
output from the programs of this Package do not automatically fall
under the copyright of this Package, but belong to whoever generated
them, and may be sold commercially, and may be aggregated with this
Package.  If such scripts or library files are aggregated with this
Package via the so-called &quot;undump&quot; or &quot;unexec&quot; methods of producing a
binary executable image, then distribution of such an image shall
neither be construed as a distribution of this Package nor shall it
fall under the restrictions of Paragraphs 3 and 4, provided that you do
not represent such an executable image as a Standard Version of this
Package.

7. C subroutines (or comparably compiled subroutines in other
languages) supplied by you and linked into this Package in order to
emulate subroutines and variables of the language defined by this
Package shall not be considered part of this Package, but are the
equivalent of input as in Paragraph 6, provided these subroutines do
not change the language in any way that would cause it to fail the
regression tests for the language.

8. Aggregation of this Package with a commercial distribution is always
permitted provided that the use of this Package is embedded; that is,
when no overt attempt is made to make this Package&#39;s interfaces visible
to the end user of the commercial distribution.  Such use shall not be
construed as a distribution of this Package.

9. The name of the Copyright Holder may not be used to endorse or promote
products derived from this software without specific prior written
permission.

10. THIS PACKAGE IS PROVIDED &quot;AS IS&quot; AND WITHOUT ANY EXPRESS OR
IMPLIED WARRANTIES, INCLUDING, WITHOUT LIMITATION, THE IMPLIED
WARRANTIES OF MERCHANTIBILITY AND FITNESS FOR A PARTICULAR PURPOSE.

                                The End

GNU Lesser General Public License Version 2.1, February 1999

The following applies to all products licensed under the
GNU Lesser General Public License, Version 2.1: You may
not use the identified files except in compliance with
the GNU Lesser General Public License, Version 2.1 (the
&quot;License&quot;). You may obtain a copy of the License at
http://www.gnu.org/licenses/lgpl-2.1.html. A copy of the
license is also reproduced below. Unless required by
applicable law or agreed to in writing, software distributed
under the License is distributed on an &quot;AS IS&quot; BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
or implied. See the License for the specific language governing
permissions and limitations under the License.

                  GNU LESSER GENERAL PUBLIC LICENSE
                       Version 2.1, February 1999

 Copyright (C) 1991, 1999 Free Software Foundation, Inc.
 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 Everyone is permitted to copy and distribute verbatim copies
 of this license document, but changing it is not allowed.

[This is the first released version of the Lesser GPL.  It also counts
 as the successor of the GNU Library Public License, version 2, hence
 the version number 2.1.]

                            Preamble

  The licenses for most software are designed to take away your
freedom to share and change it.  By contrast, the GNU General Public
Licenses are intended to guarantee your freedom to share and change
free software--to make sure the software is free for all its users.

  This license, the Lesser General Public License, applies to some
specially designated software packages--typically libraries--of the
Free Software Foundation and other authors who decide to use it.  You
can use it too, but we suggest you first think carefully about whether
this license or the ordinary General Public License is the better
strategy to use in any particular case, based on the explanations below.

  When we speak of free software, we are referring to freedom of use,
not price.  Our General Public Licenses are designed to make sure that
you have the freedom to distribute copies of free software (and charge
for this service if you wish); that you receive source code or can get
it if you want it; that you can change the software and use pieces of
it in new free programs; and that you are informed that you can do
these things.

  To protect your rights, we need to make restrictions that forbid
distributors to deny you these rights or to ask you to surrender these
rights.  These restrictions translate to certain responsibilities for
you if you distribute copies of the library or if you modify it.

  For example, if you distribute copies of the library, whether gratis
or for a fee, you must give the recipients all the rights that we gave
you.  You must make sure that they, too, receive or can get the source
code.  If you link other code with the library, you must provide
complete object files to the recipients, so that they can relink them
with the library after making changes to the library and recompiling
it.  And you must show them these terms so they know their rights.

  We protect your rights with a two-step method: (1) we copyright the
library, and (2) we offer you this license, which gives you legal
permission to copy, distribute and/or modify the library.

  To protect each distributor, we want to make it very clear that
there is no warranty for the free library.  Also, if the library is
modified by someone else and passed on, the recipients should know
that what they have is not the original version, so that the original
author&#39;s reputation will not be affected by problems that might be
introduced by others.

  Finally, software patents pose a constant threat to the existence of
any free program.  We wish to make sure that a company cannot
effectively restrict the users of a free program by obtaining a
restrictive license from a patent holder.  Therefore, we insist that
any patent license obtained for a version of the library must be
consistent with the full freedom of use specified in this license.

  Most GNU software, including some libraries, is covered by the
ordinary GNU General Public License.  This license, the GNU Lesser
General Public License, applies to certain designated libraries, and
is quite different from the ordinary General Public License.  We use
this license for certain libraries in order to permit linking those
libraries into non-free programs.

  When a program is linked with a library, whether statically or using
a shared library, the combination of the two is legally speaking a
combined work, a derivative of the original library.  The ordinary
General Public License therefore permits such linking only if the
entire combination fits its criteria of freedom.  The Lesser General
Public License permits more lax criteria for linking other code with
the library.

  We call this license the &quot;Lesser&quot; General Public License because it
does Less to protect the user&#39;s freedom than the ordinary General
Public License.  It also provides other free software developers Less
of an advantage over competing non-free programs.  These disadvantages
are the reason we use the ordinary General Public License for many
libraries.  However, the Lesser license provides advantages in certain
special circumstances.

  For example, on rare occasions, there may be a special need to
encourage the widest possible use of a certain library, so that it
becomes a de-facto standard.  To achieve this, non-free programs
must be allowed to use the library.  A more frequent case is that
a free library does the same job as widely used non-free libraries.
In this case, there is little to gain by limiting the free library
to free software only, so we use the Lesser General Public License.

  In other cases, permission to use a particular library in non-free
programs enables a greater number of people to use a large body of
free software.  For example, permission to use the GNU C Library in
non-free programs enables many more people to use the whole GNU
operating system, as well as its variant, the GNU/Linux operating
system.

  Although the Lesser General Public License is Less protective of the
users&#39; freedom, it does ensure that the user of a program that is
linked with the Library has the freedom and the wherewithal to run
that program using a modified version of the Library.

  The precise terms and conditions for copying, distribution and
modification follow.  Pay close attention to the difference between a
&quot;work based on the library&quot; and a &quot;work that uses the library&quot;.  The
former contains code derived from the library, whereas the latter must
be combined with the library in order to run.

                  GNU LESSER GENERAL PUBLIC LICENSE
   TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION

  0. This License Agreement applies to any software library or other
program which contains a notice placed by the copyright holder or
other authorized party saying it may be distributed under the terms of
this Lesser General Public License (also called &quot;this License&quot;).
Each licensee is addressed as &quot;you&quot;.

  A &quot;library&quot; means a collection of software functions and/or data
prepared so as to be conveniently linked with application programs
(which use some of those functions and data) to form executables.

  The &quot;Library&quot;, below, refers to any such software library or work
which has been distributed under these terms.  A &quot;work based on the
Library&quot; means either the Library or any derivative work under
copyright law: that is to say, a work containing the Library or a
portion of it, either verbatim or with modifications and/or translated
straightforwardly into another language.  (Hereinafter, translation is
included without limitation in the term &quot;modification&quot;.)

  &quot;Source code&quot; for a work means the preferred form of the work for
making modifications to it.  For a library, complete source code means
all the source code for all modules it contains, plus any associated
interface definition files, plus the scripts used to control
compilation and installation of the library.

  Activities other than copying, distribution and modification are not
covered by this License; they are outside its scope.  The act of
running a program using the Library is not restricted, and output from
such a program is covered only if its contents constitute a work based
on the Library (independent of the use of the Library in a tool for
writing it).  Whether that is true depends on what the Library does
and what the program that uses the Library does.


  1. You may copy and distribute verbatim copies of the Library&#39;s
complete source code as you receive it, in any medium, provided that
you conspicuously and appropriately publish on each copy an
appropriate copyright notice and disclaimer of warranty; keep intact
all the notices that refer to this License and to the absence of any
warranty; and distribute a copy of this License along with the
Library.

  You may charge a fee for the physical act of transferring a copy,
and you may at your option offer warranty protection in exchange for a
fee.


  2. You may modify your copy or copies of the Library or any portion
of it, thus forming a work based on the Library, and copy and
distribute such modifications or work under the terms of Section 1
above, provided that you also meet all of these conditions:

    a) The modified work must itself be a software library.

    b) You must cause the files modified to carry prominent notices
    stating that you changed the files and the date of any change.

    c) You must cause the whole of the work to be licensed at no
    charge to all third parties under the terms of this License.

    d) If a facility in the modified Library refers to a function or a
    table of data to be supplied by an application program that uses
    the facility, other than as an argument passed when the facility
    is invoked, then you must make a good faith effort to ensure that,
    in the event an application does not supply such function or
    table, the facility still operates, and performs whatever part of
    its purpose remains meaningful.

    (For example, a function in a library to compute square roots has
    a purpose that is entirely well-defined independent of the
    application.  Therefore, Subsection 2d requires that any
    application-supplied function or table used by this function must
    be optional: if the application does not supply it, the square
    root function must still compute square roots.)

These requirements apply to the modified work as a whole.  If
identifiable sections of that work are not derived from the Library,
and can be reasonably considered independent and separate works in
themselves, then this License, and its terms, do not apply to those
sections when you distribute them as separate works.  But when you
distribute the same sections as part of a whole which is a work based
on the Library, the distribution of the whole must be on the terms of
this License, whose permissions for other licensees extend to the
entire whole, and thus to each and every part regardless of who wrote
it.

Thus, it is not the intent of this section to claim rights or contest
your rights to work written entirely by you; rather, the intent is to
exercise the right to control the distribution of derivative or
collective works based on the Library.

In addition, mere aggregation of another work not based on the Library
with the Library (or with a work based on the Library) on a volume of
a storage or distribution medium does not bring the other work under
the scope of this License.


  3. You may opt to apply the terms of the ordinary GNU General Public
License instead of this License to a given copy of the Library.  To do
this, you must alter all the notices that refer to this License, so
that they refer to the ordinary GNU General Public License, version 2,
instead of to this License.  (If a newer version than version 2 of the
ordinary GNU General Public License has appeared, then you can specify
that version instead if you wish.)  Do not make any other change in
these notices.

  Once this change is made in a given copy, it is irreversible for
that copy, so the ordinary GNU General Public License applies to all
subsequent copies and derivative works made from that copy.

  This option is useful when you wish to copy part of the code of
the Library into a program that is not a library.


  4. You may copy and distribute the Library (or a portion or
derivative of it, under Section 2) in object code or executable form
under the terms of Sections 1 and 2 above provided that you accompany
it with the complete corresponding machine-readable source code, which
must be distributed under the terms of Sections 1 and 2 above on a
medium customarily used for software interchange.

  If distribution of object code is made by offering access to copy
from a designated place, then offering equivalent access to copy the
source code from the same place satisfies the requirement to
distribute the source code, even though third parties are not
compelled to copy the source along with the object code.


  5. A program that contains no derivative of any portion of the
Library, but is designed to work with the Library by being compiled or
linked with it, is called a &quot;work that uses the Library&quot;.  Such a
work, in isolation, is not a derivative work of the Library, and
therefore falls outside the scope of this License.

  However, linking a &quot;work that uses the Library&quot; with the Library
creates an executable that is a derivative of the Library (because it
contains portions of the Library), rather than a &quot;work that uses the
library&quot;.  The executable is therefore covered by this License.
Section 6 states terms for distribution of such executables.

  When a &quot;work that uses the Library&quot; uses material from a header file
that is part of the Library, the object code for the work may be a
derivative work of the Library even though the source code is not.
Whether this is true is especially significant if the work can be
linked without the Library, or if the work is itself a library.  The
threshold for this to be true is not precisely defined by law.

  If such an object file uses only numerical parameters, data
structure layouts and accessors, and small macros and small inline
functions (ten lines or less in length), then the use of the object
file is unrestricted, regardless of whether it is legally a derivative
work.  (Executables containing this object code plus portions of the
Library will still fall under Section 6.)

  Otherwise, if the work is a derivative of the Library, you may
distribute the object code for the work under the terms of Section 6.
Any executables containing that work also fall under Section 6,
whether or not they are linked directly with the Library itself.


  6. As an exception to the Sections above, you may also combine or
link a &quot;work that uses the Library&quot; with the Library to produce a
work containing portions of the Library, and distribute that work
under terms of your choice, provided that the terms permit
modification of the work for the customer&#39;s own use and reverse
engineering for debugging such modifications.

  You must give prominent notice with each copy of the work that the
Library is used in it and that the Library and its use are covered by
this License.  You must supply a copy of this License.  If the work
during execution displays copyright notices, you must include the
copyright notice for the Library among them, as well as a reference
directing the user to the copy of this License.  Also, you must do one
of these things:

    a) Accompany the work with the complete corresponding
    machine-readable source code for the Library including whatever
    changes were used in the work (which must be distributed under
    Sections 1 and 2 above); and, if the work is an executable linked
    with the Library, with the complete machine-readable &quot;work that
    uses the Library&quot;, as object code and/or source code, so that the
    user can modify the Library and then relink to produce a modified
    executable containing the modified Library.  (It is understood
    that the user who changes the contents of definitions files in the
    Library will not necessarily be able to recompile the application
    to use the modified definitions.)

    b) Use a suitable shared library mechanism for linking with the
    Library.  A suitable mechanism is one that (1) uses at run time a
    copy of the library already present on the user&#39;s computer system,
    rather than copying library functions into the executable, and (2)
    will operate properly with a modified version of the library, if
    the user installs one, as long as the modified version is
    interface-compatible with the version that the work was made with.

    c) Accompany the work with a written offer, valid for at
    least three years, to give the same user the materials
    specified in Subsection 6a, above, for a charge no more
    than the cost of performing this distribution.

    d) If distribution of the work is made by offering access to copy
    from a designated place, offer equivalent access to copy the above
    specified materials from the same place.

    e) Verify that the user has already received a copy of these
    materials or that you have already sent this user a copy.

  For an executable, the required form of the &quot;work that uses the
Library&quot; must include any data and utility programs needed for
reproducing the executable from it.  However, as a special exception,
the materials to be distributed need not include anything that is
normally distributed (in either source or binary form) with the major
components (compiler, kernel, and so on) of the operating system on
which the executable runs, unless that component itself accompanies
the executable.

  It may happen that this requirement contradicts the license
restrictions of other proprietary libraries that do not normally
accompany the operating system.  Such a contradiction means you cannot
use both them and the Library together in an executable that you
distribute.


  7. You may place library facilities that are a work based on the
Library side-by-side in a single library together with other library
facilities not covered by this License, and distribute such a combined
library, provided that the separate distribution of the work based on
the Library and of the other library facilities is otherwise
permitted, and provided that you do these two things:

    a) Accompany the combined library with a copy of the same work
    based on the Library, uncombined with any other library
    facilities.  This must be distributed under the terms of the
    Sections above.

    b) Give prominent notice with the combined library of the fact
    that part of it is a work based on the Library, and explaining
    where to find the accompanying uncombined form of the same work.


  8. You may not copy, modify, sublicense, link with, or distribute
the Library except as expressly provided under this License.  Any
attempt otherwise to copy, modify, sublicense, link with, or
distribute the Library is void, and will automatically terminate your
rights under this License.  However, parties who have received copies,
or rights, from you under this License will not have their licenses
terminated so long as such parties remain in full compliance.


  9. You are not required to accept this License, since you have not
signed it.  However, nothing else grants you permission to modify or
distribute the Library or its derivative works.  These actions are
prohibited by law if you do not accept this License.  Therefore, by
modifying or distributing the Library (or any work based on the
Library), you indicate your acceptance of this License to do so, and
all its terms and conditions for copying, distributing or modifying
the Library or works based on it.

  10. Each time you redistribute the Library (or any work based on the
Library), the recipient automatically receives a license from the
original licensor to copy, distribute, link with or modify the Library
subject to these terms and conditions.  You may not impose any further
restrictions on the recipients&#39; exercise of the rights granted herein.
You are not responsible for enforcing compliance by third parties with
this License.

  11. If, as a consequence of a court judgment or allegation of patent
infringement or for any other reason (not limited to patent issues),
conditions are imposed on you (whether by court order, agreement or
otherwise) that contradict the conditions of this License, they do not
excuse you from the conditions of this License.  If you cannot
distribute so as to satisfy simultaneously your obligations under this
License and any other pertinent obligations, then as a consequence you
may not distribute the Library at all.  For example, if a patent
license would not permit royalty-free redistribution of the Library by
all those who receive copies directly or indirectly through you, then
the only way you could satisfy both it and this License would be to
refrain entirely from distribution of the Library.

If any portion of this section is held invalid or unenforceable under
any particular circumstance, the balance of the section is intended
to apply, and the section as a whole is intended to apply in other
circumstances.

It is not the purpose of this section to induce you to infringe any
patents or other property right claims or to contest validity of any
such claims; this section has the sole purpose of protecting the
integrity of the free software distribution system which is
implemented by public license practices.  Many people have made
generous contributions to the wide range of software distributed
through that system in reliance on consistent application of that
system; it is up to the author/donor to decide if he or she is willing
to distribute software through any other system and a licensee cannot
impose that choice.

This section is intended to make thoroughly clear what is believed to
be a consequence of the rest of this License.

  12. If the distribution and/or use of the Library is restricted in
certain countries either by patents or by copyrighted interfaces, the
original copyright holder who places the Library under this License
may add an explicit geographical distribution limitation excluding
those countries, so that distribution is permitted only in or among
countries not thus excluded.  In such case, this License incorporates
the limitation as if written in the body of this License.

  13. The Free Software Foundation may publish revised and/or new
versions of the Lesser General Public License from time to time.
Such new versions will be similar in spirit to the present version,
but may differ in detail to address new problems or concerns.

Each version is given a distinguishing version number.  If the Library
specifies a version number of this License which applies to it and
&quot;any later version&quot;, you have the option of following the terms and
conditions either of that version or of any later version published by
the Free Software Foundation.  If the Library does not specify a
license version number, you may choose any version ever published by
the Free Software Foundation.

  14. If you wish to incorporate parts of the Library into other free
programs whose distribution conditions are incompatible with these,
write to the author to ask for permission.  For software which is
copyrighted by the Free Software Foundation, write to the Free
Software Foundation; we sometimes make exceptions for this.  Our
decision will be guided by the two goals of preserving the free status
of all derivatives of our free software and of promoting the sharing
and reuse of software generally.

                            NO WARRANTY

  15. BECAUSE THE LIBRARY IS LICENSED FREE OF CHARGE, THERE IS NO
WARRANTY FOR THE LIBRARY, TO THE EXTENT PERMITTED BY APPLICABLE LAW.
EXCEPT WHEN OTHERWISE STATED IN WRITING THE COPYRIGHT HOLDERS AND/OR
OTHER PARTIES PROVIDE THE LIBRARY &quot;AS IS&quot; WITHOUT WARRANTY OF ANY
KIND, EITHER EXPRESSED OR IMPLIED, INCLUDING, BUT NOT LIMITED TO, THE
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
PURPOSE.  THE ENTIRE RISK AS TO THE QUALITY AND PERFORMANCE OF THE
LIBRARY IS WITH YOU.  SHOULD THE LIBRARY PROVE DEFECTIVE, YOU ASSUME
THE COST OF ALL NECESSARY SERVICING, REPAIR OR CORRECTION.

  16. IN NO EVENT UNLESS REQUIRED BY APPLICABLE LAW OR AGREED TO IN
WRITING WILL ANY COPYRIGHT HOLDER, OR ANY OTHER PARTY WHO MAY MODIFY
AND/OR REDISTRIBUTE THE LIBRARY AS PERMITTED ABOVE, BE LIABLE TO YOU
FOR DAMAGES, INCLUDING ANY GENERAL, SPECIAL, INCIDENTAL OR
CONSEQUENTIAL DAMAGES ARISING OUT OF THE USE OR INABILITY TO USE THE
LIBRARY (INCLUDING BUT NOT LIMITED TO LOSS OF DATA OR DATA BEING
RENDERED INACCURATE OR LOSSES SUSTAINED BY YOU OR THIRD PARTIES OR A
FAILURE OF THE LIBRARY TO OPERATE WITH ANY OTHER SOFTWARE), EVEN IF
SUCH HOLDER OR OTHER PARTY HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH
DAMAGES.

                     END OF TERMS AND CONDITIONS

           How to Apply These Terms to Your New Libraries

  If you develop a new library, and you want it to be of the greatest
possible use to the public, we recommend making it free software that
everyone can redistribute and change.  You can do so by permitting
redistribution under these terms (or, alternatively, under the terms
of the ordinary General Public License).

  To apply these terms, attach the following notices to the library.
It is safest to attach them to the start of each source file to most
effectively convey the exclusion of warranty; and each file should
have at least the &quot;copyright&quot; line and a pointer to where the full
notice is found.

    &lt;one line to give the library&#39;s name and a brief idea of what it does.&gt;
    Copyright (C) &lt;year&gt;  &lt;name of author&gt;

    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU Lesser General Public
    License as published by the Free Software Foundation; either
    version 2.1 of the License, or (at your option) any later version.

    This library is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
    Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public
    License along with this library; if not, write to the Free Software
    Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
    02110-1301  USA

Also add information on how to contact you by electronic and paper mail.

You should also get your employer (if you work as a programmer) or your
school, if any, to sign a &quot;copyright disclaimer&quot; for the library, if
necessary.  Here is a sample; alter the names:

  Yoyodyne, Inc., hereby disclaims all copyright interest in the
  library `Frob&#39; (a library for tweaking knobs) written by James
  Random Hacker.

  &lt;signature of Ty Coon&gt;, 1 April 1990
  Ty Coon, President of Vice

That&#39;s all there is to it!

GNU Lesser General Public License Version 2, June 1991

GNU LIBRARY GENERAL PUBLIC LICENSE

Version 2, June 1991

Copyright (C) 1991 Free Software Foundation, Inc.
51 Franklin St, Fifth Floor, Boston, MA  02110-1301, USA
Everyone is permitted to copy and distribute verbatim copies
of this license document, but changing it is not allowed.

[This is the first released version of the library GPL.  It is numbered 2
because it goes with version 2 of the ordinary GPL.]

Preamble

The licenses for most software are designed to take away your freedom to
share and change it. By contrast, the GNU General Public Licenses are
intended to guarantee your freedom to share and change free software--to make
sure the software is free for all its users.

This license, the Library General Public License, applies to some specially
designated Free Software Foundation software, and to any other libraries
whose authors decide to use it. You can use it for your libraries, too.

When we speak of free software, we are referring to freedom, not price. Our
General Public Licenses are designed to make sure that you have the freedom
to distribute copies of free software (and charge for this service if you
wish), that you receive source code or can get it if you want it, that you
can change the software or use pieces of it in new free programs; and that
you know you can do these things.

To protect your rights, we need to make restrictions that forbid anyone to
deny you these rights or to ask you to surrender the rights. These
restrictions translate to certain responsibilities for you if you distribute
copies of the library, or if you modify it.

For example, if you distribute copies of the library, whether gratis or for a
fee, you must give the recipients all the rights that we gave you. You must
make sure that they, too, receive or can get the source code. If you link a
program with the library, you must provide complete object files to the
recipients so that they can relink them with the library, after making
changes to the library and recompiling it. And you must show them these terms
so they know their rights.

Our method of protecting your rights has two steps: (1) copyright the
library, and (2) offer you this license which gives you legal permission to
copy, distribute and/or modify the library.

Also, for each distributor&#39;s protection, we want to make certain that
everyone understands that there is no warranty for this free library. If the
library is modified by someone else and passed on, we want its recipients to
know that what they have is not the original version, so that any problems
introduced by others will not reflect on the original authors&#39; reputations.

Finally, any free program is threatened constantly by software patents. We
wish to avoid the danger that companies distributing free software will
individually obtain patent licenses, thus in effect transforming the program
into proprietary software. To prevent this, we have made it clear that any
patent must be licensed for everyone&#39;s free use or not licensed at all.

Most GNU software, including some libraries, is covered by the ordinary GNU
General Public License, which was designed for utility programs. This
license, the GNU Library General Public License, applies to certain
designated libraries. This license is quite different from the ordinary one;
be sure to read it in full, and don&#39;t assume that anything in it is the same
as in the ordinary license.

The reason we have a separate public license for some libraries is that they
blur the distinction we usually make between modifying or adding to a program
and simply using it. Linking a program with a library, without changing the
library, is in some sense simply using the library, and is analogous to
running a utility program or application program. However, in a textual and
legal sense, the linked executable is a combined work, a derivative of the
original library, and the ordinary General Public License treats it as such.

Because of this blurred distinction, using the ordinary General Public
License for libraries did not effectively promote software sharing, because
most developers did not use the libraries. We concluded that weaker
conditions might promote sharing better.

However, unrestricted linking of non-free programs would deprive the users of
those programs of all benefit from the free status of the libraries
themselves. This Library General Public License is intended to permit
developers of non-free programs to use free libraries, while preserving your
freedom as a user of such programs to change the free libraries that are
incorporated in them. (We have not seen how to achieve this as regards
changes in header files, but we have achieved it as regards changes in the
actual functions of the Library.) The hope is that this will lead to faster
development of free libraries.

The precise terms and conditions for copying, distribution and modification
follow. Pay close attention to the difference between a &quot;work based on the
library&quot; and a &quot;work that uses the library&quot;. The former contains code derived
from the library, while the latter only works together with the library.

Note that it is possible for a library to be covered by the ordinary General
Public License rather than by this special one.

TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION

0. This License Agreement applies to any software library which contains a
notice placed by the copyright holder or other authorized party saying it may
be distributed under the terms of this Library General Public License (also
called &quot;this License&quot;). Each licensee is addressed as &quot;you&quot;.

A &quot;library&quot; means a collection of software functions and/or data prepared so
as to be conveniently linked with application programs (which use some of
those functions and data) to form executables.

The &quot;Library&quot;, below, refers to any such software library or work which has
been distributed under these terms. A &quot;work based on the Library&quot; means
either the Library or any derivative work under copyright law: that is to
say, a work containing the Library or a portion of it, either verbatim or
with modifications and/or translated straightforwardly into another language.
(Hereinafter, translation is included without limitation in the term
&quot;modification&quot;.)

&quot;Source code&quot; for a work means the preferred form of the work for making
modifications to it. For a library, complete source code means all the source
code for all modules it contains, plus any associated interface definition
files, plus the scripts used to control compilation and installation of the
library.

Activities other than copying, distribution and modification are not covered
by this License; they are outside its scope. The act of running a program
using the Library is not restricted, and output from such a program is
covered only if its contents constitute a work based on the Library
(independent of the use of the Library in a tool for writing it). Whether
that is true depends on what the Library does and what the program that uses
the Library does.

1. You may copy and distribute verbatim copies of the Library&#39;s complete
source code as you receive it, in any medium, provided that you conspicuously
and appropriately publish on each copy an appropriate copyright notice and
disclaimer of warranty; keep intact all the notices that refer to this
License and to the absence of any warranty; and distribute a copy of this
License along with the Library.

You may charge a fee for the physical act of transferring a copy, and you may
at your option offer warranty protection in exchange for a fee.

2. You may modify your copy or copies of the Library or any portion of it,
thus forming a work based on the Library, and copy and distribute such
modifications or work under the terms of Section 1 above, provided that you
also meet all of these conditions:

    a) The modified work must itself be a software library.
    b) You must cause the files modified to carry prominent notices stating
that you changed the files and the date of any change.
    c) You must cause the whole of the work to be licensed at no charge to
all third parties under the terms of this License.
    d) If a facility in the modified Library refers to a function or a table
of data to be supplied by an application program that uses the facility,
other than as an argument passed when the facility is invoked, then you must
make a good faith effort to ensure that, in the event an application does not
supply such function or table, the facility still operates, and performs
whatever part of its purpose remains meaningful.

    (For example, a function in a library to compute square roots has a
purpose that is entirely well-defined independent of the application.
Therefore, Subsection 2d requires that any application-supplied function or
table used by this function must be optional: if the application does not
supply it, the square root function must still compute square roots.)

These requirements apply to the modified work as a whole. If identifiable
sections of that work are not derived from the Library, and can be reasonably
considered independent and separate works in themselves, then this License,
and its terms, do not apply to those sections when you distribute them as
separate works. But when you distribute the same sections as part of a whole
which is a work based on the Library, the distribution of the whole must be
on the terms of this License, whose permissions for other licensees extend to
the entire whole, and thus to each and every part regardless of who wrote it.

Thus, it is not the intent of this section to claim rights or contest your
rights to work written entirely by you; rather, the intent is to exercise the
right to control the distribution of derivative or collective works based on
the Library.

In addition, mere aggregation of another work not based on the Library with
the Library (or with a work based on the Library) on a volume of a storage or
distribution medium does not bring the other work under the scope of this
License.

3. You may opt to apply the terms of the ordinary GNU General Public License
instead of this License to a given copy of the Library. To do this, you must
alter all the notices that refer to this License, so that they refer to the
ordinary GNU General Public License, version 2, instead of to this License.
(If a newer version than version 2 of the ordinary GNU General Public License
has appeared, then you can specify that version instead if you wish.) Do not
make any other change in these notices.

Once this change is made in a given copy, it is irreversible for that copy,
so the ordinary GNU General Public License applies to all subsequent copies
and derivative works made from that copy.

This option is useful when you wish to copy part of the code of the Library
into a program that is not a library.

4. You may copy and distribute the Library (or a portion or derivative of it,
under Section 2) in object code or executable form under the terms of
Sections 1 and 2 above provided that you accompany it with the complete
corresponding machine-readable source code, which must be distributed under
the terms of Sections 1 and 2 above on a medium customarily used for software
interchange.

If distribution of object code is made by offering access to copy from a
designated place, then offering equivalent access to copy the source code
from the same place satisfies the requirement to distribute the source code,
even though third parties are not compelled to copy the source along with the
object code.

5. A program that contains no derivative of any portion of the Library, but
is designed to work with the Library by being compiled or linked with it, is
called a &quot;work that uses the Library&quot;. Such a work, in isolation, is not a
derivative work of the Library, and therefore falls outside the scope of this
License.

However, linking a &quot;work that uses the Library&quot; with the Library creates an
executable that is a derivative of the Library (because it contains portions
of the Library), rather than a &quot;work that uses the library&quot;. The executable
is therefore covered by this License. Section 6 states terms for distribution
of such executables.

When a &quot;work that uses the Library&quot; uses material from a header file that is
part of the Library, the object code for the work may be a derivative work of
the Library even though the source code is not. Whether this is true is
especially significant if the work can be linked without the Library, or if
the work is itself a library. The threshold for this to be true is not
precisely defined by law.

If such an object file uses only numerical parameters, data structure layouts
and accessors, and small macros and small inline functions (ten lines or less
in length), then the use of the object file is unrestricted, regardless of
whether it is legally a derivative work. (Executables containing this object
code plus portions of the Library will still fall under Section 6.)

Otherwise, if the work is a derivative of the Library, you may distribute the
object code for the work under the terms of Section 6. Any executables
containing that work also fall under Section 6, whether or not they are
linked directly with the Library itself.

6. As an exception to the Sections above, you may also compile or link a
&quot;work that uses the Library&quot; with the Library to produce a work containing
portions of the Library, and distribute that work under terms of your choice,
provided that the terms permit modification of the work for the customer&#39;s
own use and reverse engineering for debugging such modifications.

You must give prominent notice with each copy of the work that the Library is
used in it and that the Library and its use are covered by this License. You
must supply a copy of this License. If the work during execution displays
copyright notices, you must include the copyright notice for the Library
among them, as well as a reference directing the user to the copy of this
License. Also, you must do one of these things:

    a) Accompany the work with the complete corresponding machine-readable
source code for the Library including whatever changes were used in the work
(which must be distributed under Sections 1 and 2 above); and, if the work is
an executable linked with the Library, with the complete machine-readable
&quot;work that uses the Library&quot;, as object code and/or source code, so that the
user can modify the Library and then relink to produce a modified executable
containing the modified Library. (It is understood that the user who changes
the contents of definitions files in the Library will not necessarily be able
to recompile the application to use the modified definitions.)
    b) Accompany the work with a written offer, valid for at least three
years, to give the same user the materials specified in Subsection 6a, above,
for a charge no more than the cost of performing this distribution.
    c) If distribution of the work is made by offering access to copy from a
designated place, offer equivalent access to copy the above specified
materials from the same place.
    d) Verify that the user has already received a copy of these materials or
that you have already sent this user a copy.

For an executable, the required form of the &quot;work that uses the Library&quot; must
include any data and utility programs needed for reproducing the executable
from it. However, as a special exception, the source code distributed need
not include anything that is normally distributed (in either source or binary
form) with the major components (compiler, kernel, and so on) of the
operating system on which the executable runs, unless that component itself
accompanies the executable.

It may happen that this requirement contradicts the license restrictions of
other proprietary libraries that do not normally accompany the operating
system. Such a contradiction means you cannot use both them and the Library
together in an executable that you distribute.

7. You may place library facilities that are a work based on the Library
side-by-side in a single library together with other library facilities not
covered by this License, and distribute such a combined library, provided
that the separate distribution of the work based on the Library and of the
other library facilities is otherwise permitted, and provided that you do
these two things:

    a) Accompany the combined library with a copy of the same work based on
the Library, uncombined with any other library facilities. This must be
distributed under the terms of the Sections above.
    b) Give prominent notice with the combined library of the fact that part
of it is a work based on the Library, and explaining where to find the
accompanying uncombined form of the same work.

8. You may not copy, modify, sublicense, link with, or distribute the Library
except as expressly provided under this License. Any attempt otherwise to
copy, modify, sublicense, link with, or distribute the Library is void, and
will automatically terminate your rights under this License. However, parties
who have received copies, or rights, from you under this License will not
have their licenses terminated so long as such parties remain in full
compliance.

9. You are not required to accept this License, since you have not signed it.
However, nothing else grants you permission to modify or distribute the
Library or its derivative works. These actions are prohibited by law if you
do not accept this License. Therefore, by modifying or distributing the
Library (or any work based on the Library), you indicate your acceptance of
this License to do so, and all its terms and conditions for copying,
distributing or modifying the Library or works based on it.

10. Each time you redistribute the Library (or any work based on the
Library), the recipient automatically receives a license from the original
licensor to copy, distribute, link with or modify the Library subject to
these terms and conditions. You may not impose any further restrictions on
the recipients&#39; exercise of the rights granted herein. You are not
responsible for enforcing compliance by third parties to this License.

11. If, as a consequence of a court judgment or allegation of patent
infringement or for any other reason (not limited to patent issues),
conditions are imposed on you (whether by court order, agreement or
otherwise) that contradict the conditions of this License, they do not excuse
you from the conditions of this License. If you cannot distribute so as to
satisfy simultaneously your obligations under this License and any other
pertinent obligations, then as a consequence you may not distribute the
Library at all. For example, if a patent license would not permit
royalty-free redistribution of the Library by all those who receive copies
directly or indirectly through you, then the only way you could satisfy both
it and this License would be to refrain entirely from distribution of the
Library.

If any portion of this section is held invalid or unenforceable under any
particular circumstance, the balance of the section is intended to apply, and
the section as a whole is intended to apply in other circumstances.

It is not the purpose of this section to induce you to infringe any patents
or other property right claims or to contest validity of any such claims;
this section has the sole purpose of protecting the integrity of the free
software distribution system which is implemented by public license
practices. Many people have made generous contributions to the wide range of
software distributed through that system in reliance on consistent
application of that system; it is up to the author/donor to decide if he or
she is willing to distribute software through any other system and a licensee
cannot impose that choice.

This section is intended to make thoroughly clear what is believed to be a
consequence of the rest of this License.

12. If the distribution and/or use of the Library is restricted in certain
countries either by patents or by copyrighted interfaces, the original
copyright holder who places the Library under this License may add an
explicit geographical distribution limitation excluding those countries, so
that distribution is permitted only in or among countries not thus excluded.
In such case, this License incorporates the limitation as if written in the
body of this License.

13. The Free Software Foundation may publish revised and/or new versions of
the Library General Public License from time to time. Such new versions will
be similar in spirit to the present version, but may differ in detail to
address new problems or concerns.

Each version is given a distinguishing version number. If the Library
specifies a version number of this License which applies to it and &quot;any later
version&quot;, you have the option of following the terms and conditions either of
that version or of any later version published by the Free Software
Foundation. If the Library does not specify a license version number, you may
choose any version ever published by the Free Software Foundation.

14. If you wish to incorporate parts of the Library into other free programs
whose distribution conditions are incompatible with these, write to the
author to ask for permission. For software which is copyrighted by the Free
Software Foundation, write to the Free Software Foundation; we sometimes make
exceptions for this. Our decision will be guided by the two goals of
preserving the free status of all derivatives of our free software and of
promoting the sharing and reuse of software generally.

NO WARRANTY

15. BECAUSE THE LIBRARY IS LICENSED FREE OF CHARGE, THERE IS NO WARRANTY FOR
THE LIBRARY, TO THE EXTENT PERMITTED BY APPLICABLE LAW. EXCEPT WHEN OTHERWISE
STATED IN WRITING THE COPYRIGHT HOLDERS AND/OR OTHER PARTIES PROVIDE THE
LIBRARY &quot;AS IS&quot; WITHOUT WARRANTY OF ANY KIND, EITHER EXPRESSED OR IMPLIED,
INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
FITNESS FOR A PARTICULAR PURPOSE. THE ENTIRE RISK AS TO THE QUALITY AND
PERFORMANCE OF THE LIBRARY IS WITH YOU. SHOULD THE LIBRARY PROVE DEFECTIVE,
YOU ASSUME THE COST OF ALL NECESSARY SERVICING, REPAIR OR CORRECTION.

16. IN NO EVENT UNLESS REQUIRED BY APPLICABLE LAW OR AGREED TO IN WRITING
WILL ANY COPYRIGHT HOLDER, OR ANY OTHER PARTY WHO MAY MODIFY AND/OR
REDISTRIBUTE THE LIBRARY AS PERMITTED ABOVE, BE LIABLE TO YOU FOR DAMAGES,
INCLUDING ANY GENERAL, SPECIAL, INCIDENTAL OR CONSEQUENTIAL DAMAGES ARISING
OUT OF THE USE OR INABILITY TO USE THE LIBRARY (INCLUDING BUT NOT LIMITED TO
LOSS OF DATA OR DATA BEING RENDERED INACCURATE OR LOSSES SUSTAINED BY YOU OR
THIRD PARTIES OR A FAILURE OF THE LIBRARY TO OPERATE WITH ANY OTHER
SOFTWARE), EVEN IF SUCH HOLDER OR OTHER PARTY HAS BEEN ADVISED OF THE
POSSIBILITY OF SUCH DAMAGES.
END OF TERMS AND CONDITIONS
How to Apply These Terms to Your New Libraries

If you develop a new library, and you want it to be of the greatest possible
use to the public, we recommend making it free software that everyone can
redistribute and change. You can do so by permitting redistribution under
these terms (or, alternatively, under the terms of the ordinary General
Public License).

To apply these terms, attach the following notices to the library. It is
safest to attach them to the start of each source file to most effectively
convey the exclusion of warranty; and each file should have at least the
&quot;copyright&quot; line and a pointer to where the full notice is found.

one line to give the library&#39;s name and an idea of what it does.
Copyright (C) year  name of author

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Library General Public
License as published by the Free Software Foundation; either
version 2 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Library General Public License for more details.

You should have received a copy of the GNU Library General Public
License along with this library; if not, write to the
Free Software Foundation, Inc., 51 Franklin St, Fifth Floor,
Boston, MA  02110-1301, USA.

Also add information on how to contact you by electronic and paper mail.

You should also get your employer (if you work as a programmer) or your
school, if any, to sign a &quot;copyright disclaimer&quot; for the library, if
necessary. Here is a sample; alter the names:

Yoyodyne, Inc., hereby disclaims all copyright interest in
the library `Frob&#39; (a library for tweaking knobs) written
by James Random Hacker.

signature of Ty Coon, 1 April 1990
Ty Coon, President of Vice

That&#39;s all there is to it!

MIT License

Permission is hereby granted, free of charge, to any person obtaining a
copy of this software and associated documentation files (the &quot;Software&quot;),
to deal in the Software without restriction, including without limitation
the rights to use, copy, modify, merge, publish, distribute, sublicense,
and/or sell copies of the Software, and to permit persons to whom the
Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included
in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED &quot;AS IS&quot;, WITHOUT WARRANTY OF ANY KIND, EXPRESS
OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR
OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
OTHER DEALINGS IN THE SOFTWARE.

Written Offer for Source Code

   For any software that you receive from Oracle in binary form which is
   licensed under an open source license that gives you the right to
   receive the source code for that binary, you can obtain a copy of the
   applicable source code by visiting
   http://www.oracle.com/goto/opensourcecode. If the source code for the
   binary was not provided to you with the binary, you can also receive a
   copy of the source code on physical media by submitting a written
   request to the address listed below or by sending an email to Oracle
   using the following link:
   http://www.oracle.com/goto/opensourcecode/request.
  Oracle America, Inc.
  Attn: Senior Vice President
  Development and Engineering Legal
  500 Oracle Parkway, 10th Floor
  Redwood Shores, CA 94065

   Your request should include:

     * The name of the binary for which you are requesting the source code

     * The name and version number of the Oracle product containing the
       binary

     * The date you received the Oracle product

     * Your name

     * Your company name (if applicable)

     * Your return mailing address and email, and

     * A telephone number in the event we need to reach you.

   We may charge you a fee to cover the cost of physical media and
   processing.

   Your request must be sent
    a. within three (3) years of the date you received the Oracle product
       that included the binary that is the subject of your request, or
    b. in the case of code licensed under the GPL v3 for as long as Oracle
       offers spare parts or customer support for that product model.
</pre>
              

            
            
            </li>
          
          </ul>
        </td>
      
      
      
      
      
      
    </tr>
  
    <tr>
      
        <td>
        
          <a href="http://msgpack.org/">MessagePack for Java (0.6.12)</a> <br>
          <small><i>(http://msgpack.org/)</i></small>
        
        </td>
      
      
      
      
        <td style="width: 50%">
          <ul>
          
            <li>
            
            
              
              
                <a href="#Apache-2.0">Apache-2.0</a>
              
              
            

            
              
                <p style="padding-left: 20px;">Attribution Notice:</p>
                <pre style="max-height: 200px;">Copyright 2019, MessagePack for Java Contributors
Licensed under the Apache License, Version 2.0 (the &quot;License&quot;); you may not use this file except in compliance with the License. You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an &quot;AS IS&quot; BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.</pre>
              
            
            
            </li>
          
          </ul>
        </td>
      
      
        <td style="width: 50%">
          <ul>
          
          </ul>
        </td>
      
      
      
      
      
      
    </tr>
  
    <tr>
      
        <td>
        
          <a href="http://www.jfoenix.com/">jfoenix (8.0.7)</a> <br>
          <small><i>(http://www.jfoenix.com/)</i></small>
        
        </td>
      
      
      
      
        <td style="width: 50%">
          <ul>
          
            <li>
            
            
              
              
                <a href="#Apache-2.0">Apache-2.0</a>
              
              
            

            
              
                <p style="padding-left: 20px;">Attribution Notice:</p>
                <pre style="max-height: 200px;">Copyright owner or entity authorized by
Licensed under the Apache License, Version 2.0 (the &quot;License&quot;); you may not use this file except in compliance with the License. You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an &quot;AS IS&quot; BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.</pre>
              
            
            
            </li>
          
          </ul>
        </td>
      
      
        <td style="width: 50%">
          <ul>
          
          </ul>
        </td>
      
      
      
      
      
      
    </tr>
  
    <tr>
      
        <td>
        
          <a href="https://github.com/google/guava.git">Guava: Google Core Libraries for Java (20.0)</a> <br>
          <small><i>(https://github.com/google/guava.git)</i></small>
        
        </td>
      
      
      
      
        <td style="width: 50%">
          <ul>
          
            <li>
            
            
              
              
                <a href="#Apache-2.0">Apache-2.0</a>
              
              
            

            
              
                <p style="padding-left: 20px;">Attribution Notice:</p>
                <pre style="max-height: 200px;">Copyright 2019, Guava: Google Core Libraries for Java Contributors
Licensed under the Apache License, Version 2.0 (the &quot;License&quot;); you may not use this file except in compliance with the License. You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an &quot;AS IS&quot; BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.</pre>
              
            
            
            </li>
          
          </ul>
        </td>
      
      
        <td style="width: 50%">
          <ul>
          
            <li>
            
            
              
              
                <a href="#Public-Domain">Public-Domain</a>
              
              
            

            
              

            
            
            </li>
          
          </ul>
        </td>
      
      
      
      
      
      
    </tr>
  
    <tr>
      
        <td>
        
          <a href="http://www.jensd.de">FontAwesomeFX (8.1)</a> <br>
          <small><i>(http://www.jensd.de)</i></small>
        
        </td>
      
      
      
      
        <td style="width: 50%">
          <ul>
          
            <li>
            
            
              
              
                <a href="#Apache-2.0">Apache-2.0</a>
              
              
            

            
              
                <p style="padding-left: 20px;">Attribution Notice:</p>
                <pre style="max-height: 200px;">
Licensed under the Apache License, Version 2.0 (the &quot;License&quot;);
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an &quot;AS IS&quot; BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.</pre>
              
            
            
            </li>
          
          </ul>
        </td>
      
      
        <td style="width: 50%">
          <ul>
          
          </ul>
        </td>
      
      
      
      
      
      
    </tr>
  
    <tr>
      
        <td>
        
          <a href="http://commons.apache.org/proper/commons-codec/">Apache Commons Codec (1.11)</a> <br>
          <small><i>(http://commons.apache.org/proper/commons-codec/)</i></small>
        
        </td>
      
      
      
      
        <td style="width: 50%">
          <ul>
          
            <li>
            
            
              
              
                <a href="#Apache-2.0">Apache-2.0</a>
              
              
            

            
              
                <p style="padding-left: 20px;">Attribution Notice:</p>
                <pre style="max-height: 200px;">Copyright 2019, Apache Commons Codec Contributors
Licensed under the Apache License, Version 2.0 (the &quot;License&quot;); you may not use this file except in compliance with the License. You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an &quot;AS IS&quot; BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.</pre>
              
            
            
            </li>
          
          </ul>
        </td>
      
      
        <td style="width: 50%">
          <ul>
          
            <li>
            <b>Multi-license: </b>
            
              
              
                <a href="#Apache-2.0">Apache-2.0</a>
              
              
            
               OR 
              
                <a href="#BSD-3-Clause">BSD-3-Clause</a>
              
              
            

            
              

            
            
            </li>
          
          </ul>
        </td>
      
      
      
      
      
      
    </tr>
  
    <tr>
      
        <td>
        
          <a href="http://commons.apache.org/io/">Commons IO (2.6)</a> <br>
          <small><i>(http://commons.apache.org/io/)</i></small>
        
        </td>
      
      
      
      
        <td style="width: 50%">
          <ul>
          
            <li>
            
            
              
              
                <a href="#Apache-2.0">Apache-2.0</a>
              
              
            

            
              
                <p style="padding-left: 20px;">Attribution Notice:</p>
                <pre style="max-height: 200px;">Copyright 2019, Commons IO Contributors
Licensed under the Apache License, Version 2.0 (the &quot;License&quot;); you may not use this file except in compliance with the License. You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an &quot;AS IS&quot; BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.</pre>
              
            
            
            </li>
          
          </ul>
        </td>
      
      
        <td style="width: 50%">
          <ul>
          
          </ul>
        </td>
      
      
      
      
      
      
    </tr>
  
    <tr>
      
        <td>
        
          <a href="https://gluonhq.com/products/mobile/">Gluon Charm Down Core (3.8.6)</a> <br>
          <small><i>(https://gluonhq.com/products/mobile/)</i></small>
        
        </td>
      
      
      
      
        <td style="width: 50%">
          <ul>
          
            <li>
            
            
              
              
                <a href="#GPL-3.0-only">GPL-3.0-only</a>
              
              
            

            
              
                <p style="padding-left: 20px;">Attribution Notice:</p>
                <pre style="max-height: 200px;">Copyright (C) 2019, Gluon Charm Down Core Contributors
This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, version 3.
This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
You should have received a copy of the GNU General Public License along with this program. If not, see http://www.gnu.org/licenses/</pre>
              
            
            
            </li>
          
          </ul>
        </td>
      
      
        <td style="width: 50%">
          <ul>
          
            <li>
            
            
              
              
                <a href="#GPL-3.0-or-later">GPL-3.0-or-later</a>
              
              
            

            
              
              <p style="padding-left: 20px;">Attribution:</p>
              <pre style="max-height: 200px;">Copyright (C) 2017, Gluon
This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, version 3 or any later version.
This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
You should have received a copy of the GNU General Public License along with this program. If not, see http://www.gnu.org/licenses/</pre>
              

            
            
            </li>
          
          </ul>
        </td>
      
      
      
      
      
      
    </tr>
  
  </tbody>
</table>

          </div>
        
      

      
      <div class="alert alert-info">Deep dependencies not included.  Enable this in FOSSA to include deeper data.</div>
      

    
    <div class="alert alert-info">Full license list not included.  Enable this in FOSSA to include licenses.</div>
    
    </div>
  </body>
</html>

<!--FOSSA: Do not touch content below. -->

<!--FOSSA: ==depsig=e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855== -->



