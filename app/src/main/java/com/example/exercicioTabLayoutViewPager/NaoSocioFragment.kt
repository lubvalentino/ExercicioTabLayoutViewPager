package com.example.exercicioTabLayoutViewPager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.ViewModelProvider
import com.example.exercicioTabLayoutViewPager.model.Socio
import com.google.android.material.textfield.TextInputLayout

class NaoSocioFragment : Fragment() {

    private lateinit var tilNome : TextInputLayout
    private lateinit var tilEmail : TextInputLayout
    private lateinit var tilTelefone : TextInputLayout
    private lateinit var tilSenha : TextInputLayout
    private lateinit var tilConfirmaSenha : TextInputLayout
    private lateinit var btnCadastrar: AppCompatButton

    private lateinit var viewModel: MainViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nao_socio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initComponents()
        setUpObservables()
    }

    private fun setUpObservables() {
        btnCadastrar.setOnClickListener {
            var taTudoCerto = true
            val nome = tilNome.editText?.text.toString()
            val email = tilEmail.editText?.text.toString()
            val telefone = tilTelefone.editText?.text.toString()
            val senha = tilSenha.editText?.text.toString()
            val confirmaSenha = tilConfirmaSenha.editText?.text.toString()

            //verificar campos em brancos e mostrar erro caso esteja em branco
            if (nome.isBlank()){
                tilNome.error = "Campo obrigatório"
                taTudoCerto = false
            }else {
                //limpar o erro
                tilNome.isErrorEnabled = false
            }
            if (email.isBlank()){
                tilEmail.error = "Campo obrigatório"
                taTudoCerto = false
            }else {
                //limpar o erro
                tilEmail.isErrorEnabled = false
            }
            if (telefone.isBlank()){
                tilTelefone.error = "Campo obrigatório"
                taTudoCerto = false
            }else {
                //limpar o erro
                tilTelefone.isErrorEnabled = false
            }
            if (senha.isBlank()){
                tilSenha.error = "Campo obrigatório"
                taTudoCerto = false
            }else {
                //limpar o erro
                tilSenha.isErrorEnabled = false
            }
            if (confirmaSenha.isBlank()){
                tilConfirmaSenha.error = "Campo obrigatório"
                taTudoCerto = false
            }else {
                //limpar o erro
                tilConfirmaSenha.isErrorEnabled = false
            }
            if (taTudoCerto){
            viewModel.setNovoSocio(Socio(
                nome = nome,
                email = email,
                telefone = telefone
            ))
            }
        }
    }

    private fun initComponents() {
        //chamar edit text do xml em fragments
        activity?.let {
            viewModel = ViewModelProvider(it).get(MainViewModel::class.java)

            tilNome = it.findViewById(R.id.tilNome)
            tilEmail = it.findViewById(R.id.tilEmail)
            tilTelefone = it.findViewById(R.id.tilTelefone)
            tilSenha = it.findViewById(R.id.tilSenha)
            tilConfirmaSenha = it.findViewById(R.id.tilConfirmaSenha)
            btnCadastrar = it.findViewById(R.id.btnCadastrar)
        }



    }
}