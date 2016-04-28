package br.com.web.model;

import java.util.List;

import br.com.web.vo.Usuario;


/**
 * 
 * @author Artur
 *
 */
public class UsuarioBtp {

	List<Usuario> usuariosVO;

	public UsuarioBtp() {

	}

	public UsuarioBtp(List<Usuario> usuariosVO) {

		this.usuariosVO = usuariosVO;
	}

	public Usuario incluir(Usuario usuarioVO) {

		if(usuarioVO.getId()==null){
			Integer id = usuariosVO.size() + 1;

			usuarioVO.setId(Long.parseLong(String.valueOf(id)));
			usuariosVO.add(usuarioVO);			
		}else{
			
			alterar(usuarioVO);
		}
		
		

		return usuarioVO;
	}

	private void alterar(Usuario usuarioVO) {

		for (Usuario userOld : usuariosVO) {

			if (userOld.getId().equals(usuarioVO.getId())) {

				usuariosVO.remove(userOld);
				break;
			}
		}

		usuariosVO.add(usuarioVO);

	}

	public void excluir(Long id) {

		usuariosVO.remove(getUserById(id));

	}

	public List<Usuario> getUsuariosVO() {
		return usuariosVO;
	}

	public void setUsuariosVO(List<Usuario> usuariosVO) {
		this.usuariosVO = usuariosVO;
	}

	public Usuario getUserById(Long id) {

		Usuario usuario = null;

		for (Usuario usuarioVO : usuariosVO) {

			if (usuarioVO.getId().equals(id)) {

				usuario = usuarioVO;
				break;
			}
		}

		return usuario;
	}

}
