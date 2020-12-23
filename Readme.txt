parametri pentru rularea programului:
-setPath arg1 (inlocuieste la runtime path-ul din fisierul de configurare)
	arg1=path-ul in care se face descarcarea site-urilor

-fUrl arg1 (descarca toate site-urile din fiserul dat)
	args1=path-ul catre fisierul cu url-uri

-searchFor arg1 arg2 (cauta arg2 in paginile descarcate ale unui site gasit in arg1)
	arg1=path catre directorul unde se regaseste site-ul (ex. path/mta.ro)
	arg2=cuvantul cautat

-listType arg1 arg2 arg3
	arg1=path catre directorul unde se regaseste site-ul (ex. path/mta.ro)
	arg2=fiserul unde se va face scrierea (path/type.txt)
	arg3=tipul de fisere cautate pe site

-siteMap arg1 (creaza sitemap-ul in directorul curent)
	arg1=path catre directorul unde se regaseste site-ul (ex. path/mta.ro)

-config arg1 (seteaza path-ul catre un alt fiser de configurare, in lipsa lui se ia unul default)
	arg1=path-ul catre fiserul de configurare