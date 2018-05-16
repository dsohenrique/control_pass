package br.com.controlpass.common.business;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

public abstract class BaseSB {

    @PersistenceContext
    private EntityManager em;

    private RepositoryFactorySupport factory;

    @PostConstruct
    void postConstructCaller() {
    	factory = new JpaRepositoryFactory(em);
    	postConstructImpl();
    }
    
    protected <T> T getDAO(Class<T> clazz) {
    	List<Class<?>> lista = Arrays.asList(clazz.getInterfaces());
        for (Class<?> cls : lista) {
            if (cls.getSimpleName().contains("Custom")) {
                String classe = mountClassImpl(cls);
                try {
                    return factory
                            .getRepository(clazz, Class.forName(classe).getConstructor(EntityManager.class).newInstance(em));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        
        return (T) factory.getRepository(clazz);
    }
    
    private String mountClassImpl(Class<?> value) {
        StringBuilder url = new StringBuilder();
        url.append(value.getCanonicalName());
        int start = url.length() - (value.getSimpleName().length());
        url.replace(start, url.length(), "");
        url.append("impl.");
        url.append(value.getSimpleName().replaceAll("Custom", "Impl"));
        return url.toString();
    }
    
    protected void clearEntityManagerSession() {
    	if (em != null) {
    		em.clear();
    	}
    }
    
    protected void flushEntityManagerSession() {
    	if (em != null) {
    		em.flush();
    	}
    }
    
    protected abstract void postConstructImpl();
}
